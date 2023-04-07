package art.redoc.business.goods.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import art.redoc.business.goods.model.RelationUserFlashSalePlan;

import java.util.List;

/**
 * Relation user flash sale plan service.
 *
 * @author code generator
 */
public interface RelationUserFlashSalePlanService {

    /**
     * Get model by unique ID.
     *
     * @param id Unique ID.
     * @return Resource.
     */
    RelationUserFlashSalePlan get(Long id);

    /**
     * Get all resource.
     *
     * @param pageable Paging related params.
     * @return List resources.
     */
    Page<RelationUserFlashSalePlan> getAll(final Pageable pageable);

    /**
     * Create model.
     *
     * @param model The model needs to be created.
     * @return The model that has been created.
     */
    RelationUserFlashSalePlan create(RelationUserFlashSalePlan model);

    /**
     * Create models in batches.
     *
     * @param models Model list.
     * @return List of models that have been created.
     */
    List<RelationUserFlashSalePlan> create(List<RelationUserFlashSalePlan> models);

    /**
     * Update model.
     *
     * @param model The model needs to be updated.
     * @return The model that has been updated.
     */
    RelationUserFlashSalePlan update(RelationUserFlashSalePlan model);

    /**
     * Delete model.
     *
     * @param id Unique ID.
     */
    void delete(Long id);

    /**
     * Delete models in batches.
     *
     * @param models Model list.
     */
    void delete(List<RelationUserFlashSalePlan> models);

    List<RelationUserFlashSalePlan> getByFlashSalePlanId(Long flashSaleId);
}
