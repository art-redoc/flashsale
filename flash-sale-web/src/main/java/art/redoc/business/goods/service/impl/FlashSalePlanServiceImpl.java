package art.redoc.business.goods.service.impl;

import art.redoc.base.conts.BusinessConstants;
import art.redoc.business.goods.convertor.FlashSalePlanConvertor;
import art.redoc.dto.goods.dto.FlashSalePlanDTO;
import art.redoc.core.conts.CoreResponseCode;
import art.redoc.core.exceptions.CoreRuntimeException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import art.redoc.business.goods.model.FlashSalePlan;
import art.redoc.business.goods.repository.FlashSalePlanRepository;
import art.redoc.business.goods.service.FlashSalePlanService;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.List;

/**
 * FlashSalePlan service implement.
 *
 * @author code generator
 */
@Slf4j
@Service
public class FlashSalePlanServiceImpl implements FlashSalePlanService {

    @Autowired
    private FlashSalePlanRepository flashSalePlanRepository;
    @Autowired
    private FlashSalePlanConvertor flashSalePlanConvertor;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public FlashSalePlan get(@NonNull Long id) {
        final FlashSalePlan model = flashSalePlanRepository.findById(id).orElseThrow(() ->
                new CoreRuntimeException(CoreResponseCode.RESOURCE_NOT_EXISTS, String.format("The resource with id [%s] does not exist.",
                        id)));
        return model;
    }

    @Override
    public Page<FlashSalePlan> getAll(Pageable pageable) {
        return this.flashSalePlanRepository.findAll(pageable);
    }

    @Override
    public FlashSalePlan create(FlashSalePlan model) {
        return flashSalePlanRepository.save(model);
    }

    @Override
    public List<FlashSalePlan> create(List<FlashSalePlan> models) {
        return flashSalePlanRepository.saveAll(models);
    }

    @Override
    public FlashSalePlan update(FlashSalePlan model) {
        return flashSalePlanRepository.save(model);
    }

    @Override
    public void delete(@NonNull Long id) {
        flashSalePlanRepository.deleteById(id);
    }

    @Override
    public void delete(List<FlashSalePlan> models) {
        flashSalePlanRepository.deleteInBatch(models);
    }

    @Override
    @Transactional
    public FlashSalePlan createPlan(FlashSalePlan model) {
        final FlashSalePlan result = flashSalePlanRepository.save(model);
        String value = null;
        try {
            final FlashSalePlanDTO flashSalePlanDTO = flashSalePlanConvertor.toDTO(model, true);
            // redis不储存amount amount单独存储
            flashSalePlanDTO.setAmount(null);
            value = objectMapper.writeValueAsString(flashSalePlanDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // 将除数量其他包括商品信息等，保存在redis中
        redisTemplate.opsForZSet().add(BusinessConstants.FLASH_SALE_ZSET_KEY, value,
                result.getTriggerTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        // 将数量信息保存在redis中
        redisTemplate.opsForHash().put(BusinessConstants.FLASH_SALE_AMOUNT_HASH_KEY, result.getId().toString(), result.getAmount());
        // 每个商品秒杀时间保存在redis中
        redisTemplate.opsForHash().put(BusinessConstants.FLASH_SALE_TRIGGER_HASH_KEY, result.getId().toString(), result.getTriggerTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        return result;
    }

    @Override
    @Transactional
    public void updateStatusToFinishedAndAmountZero(Long id) {
        flashSalePlanRepository.updateStatusToFinishedAndAmountZero(id);
    }
}