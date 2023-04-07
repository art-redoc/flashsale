package art.redoc.idgenerator.controller;

import art.redoc.api.idgenerator.SnowFlakeGeneratorApi;
import art.redoc.common.service.SnowFlakeGeneratorService;
import art.redoc.core.dto.ResultDTO;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.ImmutableTag;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xerial.snappy.Snappy;
import prometheus.Remote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
public class SnowFlakeGeneratorController implements SnowFlakeGeneratorApi {

    @Autowired
    private SnowFlakeGeneratorService snowFlakeGeneratorService;

    @Autowired
    private Counter counter;

    @Override
    public ResultDTO<Long> generator() {
//        handleMetrics();
//        counter.increment();
        return ResultDTO.success(snowFlakeGeneratorService.generate(1L, 1L));
    }

    List<Tag> init() {
        ArrayList<Tag> list = new ArrayList<>();
        list.add(new ImmutableTag("service", "demo"));
        return list;
    }

    AtomicInteger atomicInteger = new AtomicInteger(0);
    AtomicInteger passCases = Metrics.gauge("redoc_gauge_value", init(), atomicInteger);
    Gauge passCaseGuage = Gauge.builder("redoc_gauge", atomicInteger, AtomicInteger::get).tag("service", "demo")
            .description("pass cases guage of demo").register(new SimpleMeterRegistry());

    public void handleMetrics() {

//        while (true) {
            final int i = RandomUtils.nextInt(1, 10000);
            passCases.getAndSet(i);
            passCaseGuage.measure();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }

    @RequestMapping(value = "/prometheus/write", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Long> prometheusWrite(@RequestBody byte[] data) {
        try {
            byte[] compressed = Snappy.uncompress(data);
            Remote.WriteRequest writeRequest = Remote.WriteRequest.parseFrom(compressed);
            log.info("Received data from Prometheus: " + writeRequest);
        } catch (IOException e) {
            log.info("Receive data from Prometheus error", e);
        }
        return ResultDTO.success(1L);
    }
}
