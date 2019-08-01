package art.redoc.business.goods.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import art.redoc.business.goods.model.Goods;

import java.util.List;

/**
 * Goods service.
 *
 * @author code generator
 */
public interface GoodsService {

    /**
     * Get model by unique ID.
     *
     * @param id Unique ID.
     * @return Resource.
     */
    Goods get(Long id);

    /**
     * Get all resource.
     *
     * @param pageable Paging related params.
     * @return List resources.
     */
    Page<Goods> getAll(final Pageable pageable);

    /**
     * Create model.
     *
     * @param model The model needs to be created.
     * @return The model that has been created.
     */
    Goods create(Goods model);

    /**
     * Create models in batches.
     *
     * @param models Model list.
     * @return List of models that have been created.
     */
    List<Goods> create(List<Goods> models);

    /**
     * Update model.
     *
     * @param model The model needs to be updated.
     * @return The model that has been updated.
     */
    Goods update(Goods model);

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
    void delete(List<Goods> models);

}