package art.redoc.consumer.consumer;

import art.redoc.consumer.base.conts.BusinessConstants;
import art.redoc.consumer.goods.model.RelationUserFlashSalePlan;
import art.redoc.consumer.goods.service.FlashSalePlanService;
import art.redoc.consumer.goods.service.RelationUserFlashSalePlanService;
import art.redoc.core.dto.ResultDTO;
import art.redoc.dto.goods.dto.FlashSalePlanDTO;
import art.redoc.dto.goods.dto.RelationUserFlashSalePlanDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

@Component
@Slf4j
public class FlashSaleConsumer {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private FlashSalePlanService flashSalePlanService;
    @Autowired
    private RelationUserFlashSalePlanService relationUserFlashSalePlanService;

    @KafkaListener(topics = {"flash_sale"})
    public void listen(ConsumerRecord<Object, String> record) throws IOException {
        final String value = record.value();
        final FlashSalePlanDTO flashSalePlanDTO = objectMapper.readValue(value, FlashSalePlanDTO.class);
        final Object o = redisTemplate.opsForHash().get(BusinessConstants.FLASH_SALE_AMOUNT_HASH_KEY, flashSalePlanDTO.getId().toString());
        // 如果redis中的amount已经被后续的逻辑删除了，或者已经小于等于0了，当前秒杀已经结束，跳出方法
        if (o == null || Integer.valueOf(o.toString()) <= 0) {
            return;
        }
        // 执行redis数量-1命令
        final Long increment = redisTemplate.opsForHash().increment(BusinessConstants.FLASH_SALE_AMOUNT_HASH_KEY,
                flashSalePlanDTO.getId().toString(), -1);
        // 如果amount-1 的结果是小于0的， 说明商品已经售罄， 不需要再进行后续操作
        if (increment == null || increment < 0) {
            return;
        }

        // 修改状态与数据库的数量
        if (increment == 0) {
            // 清除缓存
            redisTemplate.opsForHash().delete(BusinessConstants.FLASH_SALE_AMOUNT_HASH_KEY, flashSalePlanDTO.getId().toString());
            redisTemplate.opsForHash().delete(BusinessConstants.FLASH_SALE_TRIGGER_HASH_KEY, flashSalePlanDTO.getId().toString());
            final Set<String> set = redisTemplate.opsForZSet().rangeByScore(BusinessConstants.FLASH_SALE_ZSET_KEY, 0,
                    System.currentTimeMillis());
            for (String x : set) {
                try {
                    final FlashSalePlanDTO redisValue = objectMapper.readValue(x, FlashSalePlanDTO.class);
                    if (flashSalePlanDTO.getId().equals(redisValue.getId())) {
                        redisTemplate.opsForZSet().remove(BusinessConstants.FLASH_SALE_ZSET_KEY, x);
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // 更新数据库
            flashSalePlanService.updateStatusToFinishedAndAmountZero(flashSalePlanDTO.getId());
        }

        // 保存秒杀记录
        RelationUserFlashSalePlan relationUserFlashSalePlan = new RelationUserFlashSalePlan();
        relationUserFlashSalePlan.setFlashSalePlanId(flashSalePlanDTO.getId());
        relationUserFlashSalePlan.setUserId(flashSalePlanDTO.getUserId());
        relationUserFlashSalePlanService.create(relationUserFlashSalePlan);
    }
}
