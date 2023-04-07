package art.redoc.business.flashsale.service;

import art.redoc.base.conts.BusinessConstants;
import art.redoc.base.model.MessageModel;
import art.redoc.dto.goods.dto.FlashSalePlanDTO;
import art.redoc.business.goods.model.FlashSalePlan;
import art.redoc.business.goods.service.FlashSalePlanService;
import art.redoc.business.kafka.producer.FlashSaleProducer;
import art.redoc.core.dto.ResultDTO;
import art.redoc.dto.goods.enums.FlashSaleStatusEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * FlashSale service implement.
 *
 * @author code generator
 */
@Slf4j
@Service
public class FlashSaleService {

    @Autowired
    private FlashSalePlanService flashSalePlanService;
    @Autowired
    private FlashSaleProducer flashSaleProducer;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    public ResultDTO<MessageModel> startFlashSale(FlashSalePlanDTO flashSalePlanDTO) throws JsonProcessingException {
        final Long flashSaleId = flashSalePlanDTO.getId();
        final Long userId = flashSalePlanDTO.getUserId();
        final Object o = redisTemplate.opsForHash().get(BusinessConstants.FLASH_SALE_TRIGGER_HASH_KEY, flashSaleId.toString());
        if (o == null || StringUtils.isBlank(o.toString())) {
            return ResultDTO.success(new MessageModel("秒杀结束"));
        }
        long value = Long.valueOf(o.toString());
        Instant instant = Instant.ofEpochMilli(value);
        ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        if (localDateTime.isAfter(LocalDateTime.now())) {
            return ResultDTO.success(new MessageModel("秒杀没开始"));
        }
        final Object amountObject = redisTemplate.opsForHash().get(BusinessConstants.FLASH_SALE_AMOUNT_HASH_KEY, flashSaleId.toString());
        if (amountObject == null || StringUtils.isBlank(amountObject.toString())) {
            return ResultDTO.success(new MessageModel("秒杀结束"));
        }
        final Integer amount = Integer.valueOf(amountObject.toString());

        if (amount <= 0) {
            return ResultDTO.success(new MessageModel("商品售罄"));
        }
        final String message = objectMapper.writeValueAsString(flashSalePlanDTO);
        flashSaleProducer.sendFlashSale(message);
        return ResultDTO.success(new MessageModel("请等待结果"));
    }
}