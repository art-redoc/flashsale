package redoc.sq.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redoc.sq.base.convertors.AbstractConvertor;
import redoc.sq.dto.GoodsOrderDTO;
import redoc.sq.model.GoodsOrder;
import redoc.sq.service.GoodsOrderService;
import lombok.NonNull;

/**
 * GoodsOrderConvertor
 */
@Component
public class GoodsOrderConvertor extends AbstractConvertor<GoodsOrder, GoodsOrderDTO> {

    @Autowired
    private GoodsOrderService goodsOrderService;
    
    @Override
    public GoodsOrder toModel(@NonNull final GoodsOrderDTO dto) {
        if (dto.isNew()) {//新增
            return constructModel(dto);
        } else {//更新
            return updateModel(dto);
        }
    }

    @Override
    public GoodsOrderDTO toDTO(@NonNull final GoodsOrder model, final boolean forListView) {
        final GoodsOrderDTO dto = new GoodsOrderDTO();
        dto.setId(model.getId());
        dto.setGoods(model.getGoods());

        return dto;
    }

    // 构建新Model
    private GoodsOrder constructModel(final GoodsOrderDTO dto) {
        GoodsOrder model = new GoodsOrder();
        model.setGoods(dto.getGoods());

        return model;
    }

    // 更新Model
    private GoodsOrder updateModel(final GoodsOrderDTO dto) {
        GoodsOrder model = goodsOrderService.get(dto.getId());
        model.setGoods(dto.getGoods());

        return model;
    }
}