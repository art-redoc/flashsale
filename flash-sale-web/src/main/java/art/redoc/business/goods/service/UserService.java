package art.redoc.business.goods.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import art.redoc.business.goods.model.User;

import java.util.List;

/**
 * User service.
 *
 * @author code generator
 */
public interface UserService {

    /**
     * Get model by unique ID.
     *
     * @param id Unique ID.
     * @return Resource.
     */
    User get(Long id);

    /**
     * Get all resource.
     *
     * @param pageable Paging related params.
     * @return List resources.
     */
    Page<User> getAll(final Pageable pageable);

    /**
     * Create model.
     *
     * @param model The model needs to be created.
     * @return The model that has been created.
     */
    User create(User model);

    /**
     * Create models in batches.
     *
     * @param models Model list.
     * @return List of models that have been created.
     */
    List<User> create(List<User> models);

    /**
     * Update model.
     *
     * @param model The model needs to be updated.
     * @return The model that has been updated.
     */
    User update(User model);

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
    void delete(List<User> models);
}
