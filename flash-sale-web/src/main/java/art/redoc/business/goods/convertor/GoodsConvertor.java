package art.redoc.business.goods.convertor;

import art.redoc.core.convertors.AbstractConvertor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import art.redoc.business.goods.dto.GoodsDTO;
import art.redoc.business.goods.model.Goods;
import art.redoc.business.goods.service.GoodsService;

/**
 * Goods convertor.
 *
 * @author code generator
 */
@Component
public class GoodsConvertor extends AbstractConvertor<Goods, GoodsDTO> {

    @Autowired
    private GoodsService goodsService;

    @Override
    public Goods toModel(@NonNull final GoodsDTO dto) {
        if (dto.isNew()) {
            return constructModel(dto);
        } else {
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

    /**
     * Build the new model by DTO.
     *
     * @param dto DTO.
     * @return The newly built model.
     */
    private Goods constructModel(final GoodsDTO dto) {
        Goods model = new Goods();
        model.setName(dto.getName());

        return model;
    }

    /**
     * Update the model by DTO.
     *
     * @param dto DTO.
     * @return The updated model.
     */
    private Goods updateModel(final GoodsDTO dto) {
        Goods model = goodsService.get(dto.getId());
        model.setName(dto.getName());

        return model;
    }
}