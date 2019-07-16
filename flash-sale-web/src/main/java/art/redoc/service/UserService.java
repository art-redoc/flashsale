package art.redoc.service;

import art.redoc.model.User;

import java.util.List;

/**
 * UserService
 */
public interface UserService {

    /**
     * 根据ID获取资源
     *
     * @param id 资源实例ID
     * @return id所指向的资源实例
     */
    User get(Long id);

    /**
     * 创建
     *
     * @param model 资源实例
     * @return 创建后的对象
     */
    User create(User model);

    /**
     * 批量创建
     *
     * @param models 资源实例
     * @return 创建后的对象
     */
    List<User> create(List<User> models);

    /**
     * 更新
     *
     * @param model 编辑后的资源实例
     * @return 修改后的对象
     */
    User update(User model);
    
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
    void delete(List<User> models);

}