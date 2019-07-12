package redoc.sq.service.impl;

import redoc.sq.base.conts.RequestCode;
import redoc.sq.base.exceptions.CustomRuntimeException;
import redoc.sq.model.FlashSalePlan;
import redoc.sq.repository.FlashSalePlanRepository;
import redoc.sq.service.FlashSalePlanService;
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
    public FlashSalePlan get(@NonNull String id) {
        final FlashSalePlan model = flashSalePlanRepository.findById(id).orElseThrow(()-> new CustomRuntimeException(RequestCode.USER_NOT_EXISTS, String.format("id为[%s]资源不存在", id)));
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
    public void delete(@NonNull String id) {
        flashSalePlanRepository.deleteById(id);
    }

    @Override
    public void delete(List<FlashSalePlan> models) {
        flashSalePlanRepository.deleteInBatch(models);
    }
}