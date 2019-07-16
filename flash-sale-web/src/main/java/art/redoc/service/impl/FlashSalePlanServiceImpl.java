package art.redoc.service.impl;

import art.redoc.core.conts.RequestCode;
import art.redoc.core.exceptions.CoreRuntimeException;
import art.redoc.model.FlashSalePlan;
import art.redoc.repository.FlashSalePlanRepository;
import art.redoc.service.FlashSalePlanService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * FlashSalePlanService 实现类
 */
@Slf4j
@Service
public class FlashSalePlanServiceImpl implements FlashSalePlanService {

    @Autowired
    private FlashSalePlanRepository flashSalePlanRepository;

    @Override
    @Transactional(readOnly = true)
    public FlashSalePlan get(@NonNull Long id) {
        final FlashSalePlan model = flashSalePlanRepository.findById(id).orElseThrow(()-> new CoreRuntimeException(RequestCode.USER_NOT_EXISTS, String.format("id为[%s]资源不存在", id)));
        return model;
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
}