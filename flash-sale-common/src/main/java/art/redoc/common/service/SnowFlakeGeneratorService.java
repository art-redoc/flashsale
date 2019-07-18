package art.redoc.common.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Generate ID by snow flake.
 *
 * @author redoc
 */
@Slf4j
@Service
public class SnowFlakeGeneratorService {

    // base timestamp.
//    private final static long twepoch = 1288834974657L;
    private final static long twepoch = 0L;

    private final static long workerIdBits = 5L;
    private final static long dataCenterIdBits = 5L;

    // max work id is -1L << 5L, general result is 32, in simple terms, the max work id is 32.
    private final static long maxWorkerId = -1L ^ (-1L << workerIdBits);

    // max data center id is -1L << 5L, general result is 32, in simple terms, max data center id is 32.
    private final static long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);
    // bits of sequence
    private final static long sequenceBits = 12L;

    private final static long workerIdShift = sequenceBits;
    private final static long dataCenterIdShift = sequenceBits + workerIdBits;
    private final static long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;

    // the maximum sequence that can be generated per millisecond
    private final static long maxSequencePerMillisecond = -1L ^ (-1L << sequenceBits);

    // sequence max 4096 - 1
    private static long sequence = 1;
    // last timestamp
    private static long lastTimestamp = -1L;

    /**
     * Generate snow flake ID.
     *
     * @param workerId     Work ID, can't more than {@link SnowFlakeGeneratorService#maxWorkerId}.
     * @param dataCenterId Data center ID, can't more than {@link SnowFlakeGeneratorService#maxDataCenterId}.
     * @return ID.
     */
    public synchronized long generate(Long workerId, Long dataCenterId) {
        checkParams(workerId, dataCenterId);
        // get current time.
        long timestamp = getCurrentTime();

        // fault tolerance.
        if (timestamp < lastTimestamp) {
            log.error("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(String.format(
                    "Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        // if current time equals last time, add the sequence.
        if (lastTimestamp == timestamp) {
            // if sequence more than maxSequencePerMillisecond, set the sequence to 0, else add the sequence.
            sequence = (sequence + 1) & maxSequencePerMillisecond;
            // if sequence equals 0, blocking the thread until the next time.
            if (sequence == 0) {
                timestamp = tilNextTime(lastTimestamp);
            }
            // else reset the sequence.
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;

        // generate the result
        // timestamp(41bit) | dataCenterId(5bit) | workerId(5bit) | sequence(12bit)
        // total 63bit, the first bit determine positive or negative, so we don't use it.
        return ((timestamp - twepoch) << timestampLeftShift) | (dataCenterId << dataCenterIdShift)
                | (workerId << workerIdShift) | sequence;
    }

    /**
     * Check params.
     *
     * @param workerId     worker ID.
     * @param dataCenterId data center ID.
     */
    private void checkParams(Long workerId, Long dataCenterId) {
        // sanity check for worker ID, the worker ID can't more than maxWorkerId or less than zero.
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        // sanity check for data center ID, the data center ID can't more than maxDataCenterId or less than zero.
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0", maxDataCenterId));
        }
    }

    /**
     * if the number of ids {@link SnowFlakeGeneratorService#sequence} more than
     * {@link SnowFlakeGeneratorService#maxSequencePerMillisecond} generated
     * at last time, then blocking the thread until the next time to start generating the id.
     *
     * @param lastTimestamp Last ID generation time.
     * @return
     */
    private long tilNextTime(long lastTimestamp) {
        long timestamp = getCurrentTime();
        while (timestamp <= lastTimestamp) {
            timestamp = getCurrentTime();
        }
        return timestamp;
    }

    /**
     * Get current time.
     *
     * @return Current time.
     */
    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

}
