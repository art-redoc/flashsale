package art.redoc.business.goods.convertor;

import art.redoc.core.convertors.AbstractConvertor;
import art.redoc.business.goods.dto.FlashSalePlanDTO;
import art.redoc.business.goods.model.FlashSalePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import art.redoc.business.goods.service.FlashSalePlanService;
import lombok.NonNull;

/**
 * FlashSalePlanConvertor
 */
@Component
public class FlashSalePlanConvertor extends AbstractConvertor<FlashSalePlan, FlashSalePlanDTO> {

    @Autowired
    private FlashSalePlanService flashSalePlanService;
    
    @Override
    public FlashSalePlan toModel(@NonNull final FlashSalePlanDTO dto) {
        if (dto.isNew()) {//新增
            return constructModel(dto);
        } else {//更新
            return updateModel(dto);
        }
    }

    @Override
    public FlashSalePlanDTO toDTO(@NonNull final FlashSalePlan model, final boolean forListView) {
        final FlashSalePlanDTO dto = new FlashSalePlanDTO();
        dto.setId(model.getId());
        dto.setGoods(model.getGoods());
        dto.setTriggerTime(model.getTriggerTime());
        dto.setAmount(model.getAmount());

        return dto;
    }

    // 构建新Model
    private FlashSalePlan constructModel(final FlashSalePlanDTO dto) {
        FlashSalePlan model = new FlashSalePlan();
        model.setGoods(dto.getGoods());
        model.setTriggerTime(dto.getTriggerTime());
        model.setAmount(dto.getAmount());

        return model;
    }

    // 更新Model
    private FlashSalePlan updateModel(final FlashSalePlanDTO dto) {
        FlashSalePlan model = flashSalePlanService.get(dto.getId());
        model.setGoods(dto.getGoods());
        model.setTriggerTime(dto.getTriggerTime());
        model.setAmount(dto.getAmount());

        return model;
    }
}