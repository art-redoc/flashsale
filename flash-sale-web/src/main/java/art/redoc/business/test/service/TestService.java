package art.redoc.business.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import art.redoc.business.test.model.Test;

import java.util.List;

/**
 * TestService
 */
public interface TestService {

    /**
     * 根据ID获取资源
     *
     * @param id 资源实例ID
     * @return id所指向的资源实例
     */
    Test get(Long id);

    /**
     * Get all resource.
     *
     * @param pageable Pageable.
     * @return
     */
    Page<Test> getAll(final Pageable pageable);

    /**
     * 创建
     *
     * @param model 资源实例
     * @return 创建后的对象
     */
    Test create(Test model);

    /**
     * 批量创建
     *
     * @param models 资源实例
     * @return 创建后的对象
     */
    List<Test> create(List<Test> models);

    /**
     * 更新
     *
     * @param model 编辑后的资源实例
     * @return 修改后的对象
     */
    Test update(Test model);
    
    /**
     * 删除
     *
     * @param id 资源实例ID
     */
    void delete(Long id);

    /**
     * 批量删除
     *
     * @param models 资源实例集合
     */
    void delete(List<Test> models);

}