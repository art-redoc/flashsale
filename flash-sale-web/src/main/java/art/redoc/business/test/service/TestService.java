package art.redoc.business.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import art.redoc.business.test.model.Test;

import java.util.List;

/**
 * Test service.
 *
 * @author code generator
 */
public interface TestService {

    /**
     * Get model by unique ID.
     *
     * @param id Unique ID.
     * @return Resource.
     */
    Test get(Long id);

    /**
     * Get all resource.
     *
     * @param pageable Paging related params.
     * @return List resources.
     */
    Page<Test> getAll(final Pageable pageable);

    /**
     * Create model.
     *
     * @param model The model needs to be created.
     * @return The model that has been created.
     */
    Test create(Test model);

    /**
     * Create models in batches.
     *
     * @param models Model list.
     * @return List of models that have been created.
     */
    List<Test> create(List<Test> models);

    /**
     * Update model.
     *
     * @param model The model needs to be updated.
     * @return The model that has been updated.
     */
    Test update(Test model);

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
    void delete(List<Test> models);

}