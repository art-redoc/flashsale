package art.redoc.service;

import art.redoc.model.FlashSalePlan;

import java.util.List;

/**
 * FlashSalePlanService
 */
public interface FlashSalePlanService {

    /**
     * 根据ID获取资源
     *
     * @param id 资源实例ID
     * @return id所指向的资源实例
     */
    FlashSalePlan get(Long id);

    /**
     * 创建
     *
     * @param model 资源实例
     * @return 创建后的对象
     */
    FlashSalePlan create(FlashSalePlan model);

    /**
     * 批量创建
     *
     * @param models 资源实例
     * @return 创建后的对象
     */
    List<FlashSalePlan> create(List<FlashSalePlan> models);

    /**
     * 更新
     *
     * @param model 编辑后的资源实例
     * @return 修改后的对象
     */
    FlashSalePlan update(FlashSalePlan model);
    
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
    void delete(List<FlashSalePlan> models);

}