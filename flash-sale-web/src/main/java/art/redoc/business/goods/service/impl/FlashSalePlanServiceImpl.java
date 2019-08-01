package art.redoc.business.goods.service.impl;

import art.redoc.core.conts.CoreResponseCode;
import art.redoc.core.exceptions.CoreRuntimeException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import art.redoc.business.goods.model.FlashSalePlan;
import art.redoc.business.goods.repository.FlashSalePlanRepository;
import art.redoc.business.goods.service.FlashSalePlanService;

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

    @Override
    public FlashSalePlan get(@NonNull Long id) {
        final FlashSalePlan model = flashSalePlanRepository.findById(id).orElseThrow(() ->
                new CoreRuntimeException(CoreResponseCode.RESOURCE_NOT_EXISTS, String.format("The resource with id [%s] does not exist.", id)));
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
}