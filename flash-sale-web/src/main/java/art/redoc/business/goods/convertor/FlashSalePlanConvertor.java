package art.redoc.business.goods.convertor;

import art.redoc.core.convertors.AbstractConvertor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import art.redoc.business.goods.dto.FlashSalePlanDTO;
import art.redoc.business.goods.model.FlashSalePlan;
import art.redoc.business.goods.service.FlashSalePlanService;

/**
 * FlashSalePlan convertor.
 *
 * @author code generator
 */
@Component
public class FlashSalePlanConvertor extends AbstractConvertor<FlashSalePlan, FlashSalePlanDTO> {

    @Autowired
    private FlashSalePlanService flashSalePlanService;

    @Override
    public FlashSalePlan toModel(@NonNull final FlashSalePlanDTO dto) {
        if (dto.isNew()) {
            return constructModel(dto);
        } else {
            return updateModel(dto);
        }
    }

    @Override
    public FlashSalePlanDTO toDTO(@NonNull final FlashSalePlan model, final boolean forListView) {
        final FlashSalePlanDTO dto = new FlashSalePlanDTO();
        dto.setId(model.getId());
        dto.setTriggerTime(model.getTriggerTime());
        dto.setAmount(model.getAmount());

        return dto;
    }

    /**
     * Build the new model by DTO.
     *
     * @param dto DTO.
     * @return The newly built model.
     */
    private FlashSalePlan constructModel(final FlashSalePlanDTO dto) {
        FlashSalePlan model = new FlashSalePlan();
        model.setTriggerTime(dto.getTriggerTime());
        model.setAmount(dto.getAmount());

        return model;
    }

    /**
     * Update the model by DTO.
     *
     * @param dto DTO.
     * @return The updated model.
     */
    private FlashSalePlan updateModel(final FlashSalePlanDTO dto) {
        FlashSalePlan model = flashSalePlanService.get(dto.getId());
        model.setTriggerTime(dto.getTriggerTime());
        model.setAmount(dto.getAmount());

        return model;
    }
}