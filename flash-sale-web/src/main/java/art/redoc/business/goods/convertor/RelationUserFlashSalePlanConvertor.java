package art.redoc.business.goods.convertor;

import art.redoc.core.convertors.AbstractConvertor;
import art.redoc.dto.goods.dto.RelationUserFlashSalePlanDTO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import art.redoc.business.goods.model.RelationUserFlashSalePlan;
import art.redoc.business.goods.service.RelationUserFlashSalePlanService;

/**
 * Relation user flash sale plan convertor.
 *
 * @author code generator
 */
@Component
public class RelationUserFlashSalePlanConvertor extends AbstractConvertor<RelationUserFlashSalePlan, RelationUserFlashSalePlanDTO> {

    @Autowired
    private RelationUserFlashSalePlanService relationUserFlashSalePlanService;

    @Override
    public RelationUserFlashSalePlan toModel(@NonNull final RelationUserFlashSalePlanDTO dto) {
        if (dto.isNew()) {
            return constructModel(dto);
        } else {
            return updateModel(dto);
        }
    }

    @Override
    public RelationUserFlashSalePlanDTO toDTO(@NonNull final RelationUserFlashSalePlan model, final boolean forListView) {
        final RelationUserFlashSalePlanDTO dto = new RelationUserFlashSalePlanDTO();
        dto.setId(model.getId());

        return dto;
    }

    /**
     * Build the new model by DTO.
     *
     * @param dto DTO.
     * @return The newly built model.
     */
    private RelationUserFlashSalePlan constructModel(final RelationUserFlashSalePlanDTO dto) {
        RelationUserFlashSalePlan model = new RelationUserFlashSalePlan();

        return model;
    }

    /**
     * Update the model by DTO.
     *
     * @param dto DTO.
     * @return The updated model.
     */
    private RelationUserFlashSalePlan updateModel(final RelationUserFlashSalePlanDTO dto) {
        RelationUserFlashSalePlan model = relationUserFlashSalePlanService.get(dto.getId());

        return model;
    }
}
