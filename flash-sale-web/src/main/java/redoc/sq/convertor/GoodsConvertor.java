package redoc.sq.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redoc.sq.base.convertors.AbstractConvertor;
import redoc.sq.dto.GoodsDTO;
import redoc.sq.model.Goods;
import redoc.sq.service.GoodsService;
import lombok.NonNull;

/**
 * GoodsConvertor
 */
@Component
public class GoodsConvertor extends AbstractConvertor<Goods, GoodsDTO> {

    @Autowired
    private GoodsService goodsService;
    
    @Override
    public Goods toModel(@NonNull final GoodsDTO dto) {
        if (dto.isNew()) {//新增
            return constructModel(dto);
        } else {//更新
            return updateModel(dto);
        }
    }

    @Override
    public GoodsDTO toDTO(@NonNull final Goods model, final boolean forListView) {
        final GoodsDTO dto = new GoodsDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());

        return dto;
    }

    // 构建新Model
    private Goods constructModel(final GoodsDTO dto) {
        Goods model = new Goods();
        model.setName(dto.getName());

        return model;
    }

    // 更新Model
    private Goods updateModel(final GoodsDTO dto) {
        Goods model = goodsService.get(dto.getId());
        model.setName(dto.getName());

        return model;
    }
}