package art.redoc.business.goods.service.impl;

import art.redoc.core.conts.CoreResponseCode;
import art.redoc.core.exceptions.CoreRuntimeException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import art.redoc.business.goods.model.RelationUserFlashSalePlan;
import art.redoc.business.goods.repository.RelationUserFlashSalePlanRepository;
import art.redoc.business.goods.service.RelationUserFlashSalePlanService;

import java.util.List;

/**
 * Relation user flash sale plan service implement.
 *
 * @author code generator
 */
@Slf4j
@Service
public class RelationUserFlashSalePlanServiceImpl implements RelationUserFlashSalePlanService {

    @Autowired
    private RelationUserFlashSalePlanRepository relationUserFlashSalePlanRepository;

    @Override
    public RelationUserFlashSalePlan get(@NonNull Long id) {
        final RelationUserFlashSalePlan model = relationUserFlashSalePlanRepository.findById(id).orElseThrow(() ->
                new CoreRuntimeException(CoreResponseCode.RESOURCE_NOT_EXISTS,
                        String.format("The resource with id [%s] does not exist.", id)));
        return model;
    }

    @Override
    public Page<RelationUserFlashSalePlan> getAll(Pageable pageable) {
        return this.relationUserFlashSalePlanRepository.findAll(pageable);
    }

    @Override
    public RelationUserFlashSalePlan create(RelationUserFlashSalePlan model) {
        return relationUserFlashSalePlanRepository.save(model);
    }

    @Override
    public List<RelationUserFlashSalePlan> create(List<RelationUserFlashSalePlan> models) {
        return relationUserFlashSalePlanRepository.saveAll(models);
    }

    @Override
    public RelationUserFlashSalePlan update(RelationUserFlashSalePlan model) {
        return relationUserFlashSalePlanRepository.save(model);
    }

    @Override
    public void delete(@NonNull Long id) {
        relationUserFlashSalePlanRepository.deleteById(id);
    }

    @Override
    public void delete(List<RelationUserFlashSalePlan> models) {
        relationUserFlashSalePlanRepository.deleteInBatch(models);
    }

    @Override
    public List<RelationUserFlashSalePlan> getByFlashSalePlanId(Long flashSaleId) {
        return relationUserFlashSalePlanRepository.findByFlashSalePlanId(flashSaleId);
    }
}
