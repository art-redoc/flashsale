package art.redoc.business.goods.service;

import art.redoc.business.goods.model.GoodsOrder;

import java.util.List;

/**
 * GoodsOrderService
 */
public interface GoodsOrderService {

    /**
     * 根据ID获取资源
     *
     * @param id 资源实例ID
     * @return id所指向的资源实例
     */
    GoodsOrder get(Long id);

    /**
     * 创建
     *
     * @param model 资源实例
     * @return 创建后的对象
     */
    GoodsOrder create(GoodsOrder model);

    /**
     * 批量创建
     *
     * @param models 资源实例
     * @return 创建后的对象
     */
    List<GoodsOrder> create(List<GoodsOrder> models);

    /**
     * 更新
     *
     * @param model 编辑后的资源实例
     * @return 修改后的对象
     */
    GoodsOrder update(GoodsOrder model);
    
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
    void delete(List<GoodsOrder> models);

}