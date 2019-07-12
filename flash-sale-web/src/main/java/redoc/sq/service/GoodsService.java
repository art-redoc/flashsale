package redoc.sq.service;

import redoc.sq.model.Goods;

import java.util.List;

/**
 * GoodsService
 */
public interface GoodsService {

    /**
     * 根据ID获取资源
     *
     * @param id 资源实例ID
     * @return id所指向的资源实例
     */
    Goods get(String id);

    /**
     * 创建
     *
     * @param model 资源实例
     * @return 创建后的对象
     */
    Goods create(Goods model);

    /**
     * 批量创建
     *
     * @param models 资源实例
     * @return 创建后的对象
     */
    List<Goods> create(List<Goods> models);

    /**
     * 更新
     *
     * @param model 编辑后的资源实例
     * @return 修改后的对象
     */
    Goods update(Goods model);
    
    /**
     * 删除
     *
     * @param id 资源实例ID
     */
    void delete(String id);

    /**
     * 批量删除
     *
     * @param models 资源实例集合
     */
    void delete(List<Goods> models);

}