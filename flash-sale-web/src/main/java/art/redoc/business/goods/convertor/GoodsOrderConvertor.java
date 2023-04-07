package art.redoc.business.goods.convertor;

import art.redoc.core.convertors.AbstractConvertor;
import art.redoc.dto.goods.dto.GoodsOrderDTO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import art.redoc.business.goods.model.GoodsOrder;
import art.redoc.business.goods.service.GoodsOrderService;

/**
 * GoodsOrder convertor.
 *
 * @author code generator
 */
@Component
public class GoodsOrderConvertor extends AbstractConvertor<GoodsOrder, GoodsOrderDTO> {

    @Autowired
    private GoodsOrderService goodsOrderService;

    @Override
    public GoodsOrder toModel(@NonNull final GoodsOrderDTO dto) {
        if (dto.isNew()) {
            return constructModel(dto);
        } else {
            return updateModel(dto);
        }
    }

    @Override
    public GoodsOrderDTO toDTO(@NonNull final GoodsOrder model, final boolean forListView) {
        final GoodsOrderDTO dto = new GoodsOrderDTO();
        dto.setId(model.getId());

        return dto;
    }

    /**
     * Build the new model by DTO.
     *
     * @param dto DTO.
     * @return The newly built model.
     */
    private GoodsOrder constructModel(final GoodsOrderDTO dto) {
        GoodsOrder model = new GoodsOrder();

        return model;
    }

    /**
     * Update the model by DTO.
     *
     * @param dto DTO.
     * @return The updated model.
     */
    private GoodsOrder updateModel(final GoodsOrderDTO dto) {
        GoodsOrder model = goodsOrderService.get(dto.getId());

        return model;
    }
}