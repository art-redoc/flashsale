package art.redoc.business.goods.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import art.redoc.business.goods.model.FlashSalePlan;

import java.util.List;

/**
 * FlashSalePlan service.
 *
 * @author code generator
 */
public interface FlashSalePlanService {

    /**
     * Get model by unique ID.
     *
     * @param id Unique ID.
     * @return Resource.
     */
    FlashSalePlan get(Long id);

    /**
     * Get all resource.
     *
     * @param pageable Paging related params.
     * @return List resources.
     */
    Page<FlashSalePlan> getAll(final Pageable pageable);

    /**
     * Create model.
     *
     * @param model The model needs to be created.
     * @return The model that has been created.
     */
    FlashSalePlan create(FlashSalePlan model);

    /**
     * Create models in batches.
     *
     * @param models Model list.
     * @return List of models that have been created.
     */
    List<FlashSalePlan> create(List<FlashSalePlan> models);

    /**
     * Update model.
     *
     * @param model The model needs to be updated.
     * @return The model that has been updated.
     */
    FlashSalePlan update(FlashSalePlan model);

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
    void delete(List<FlashSalePlan> models);

}