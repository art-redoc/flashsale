package art.redoc.consumer.goods.service;

import art.redoc.consumer.goods.model.RelationUserFlashSalePlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Relation user flash sale plan service.
 *
 * @author code generator
 */
public interface RelationUserFlashSalePlanService {

    /**
     * Create model.
     *
     * @param model The model needs to be created.
     * @return The model that has been created.
     */
    RelationUserFlashSalePlan create(RelationUserFlashSalePlan model);
}
