package art.redoc.consumer.goods.service.impl;

import art.redoc.consumer.goods.model.RelationUserFlashSalePlan;
import art.redoc.consumer.goods.repository.RelationUserFlashSalePlanRepository;
import art.redoc.consumer.goods.service.RelationUserFlashSalePlanService;
import art.redoc.core.conts.CoreResponseCode;
import art.redoc.core.exceptions.CoreRuntimeException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public RelationUserFlashSalePlan create(RelationUserFlashSalePlan model) {
        return relationUserFlashSalePlanRepository.save(model);
    }
}
