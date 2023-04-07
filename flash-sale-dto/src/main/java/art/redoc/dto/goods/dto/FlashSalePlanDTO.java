package art.redoc.dto.goods.dto;

import art.redoc.core.dto.AbstractAuditDTO;
import art.redoc.dto.goods.enums.FlashSaleStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FlashSalePlanDTO extends AbstractAuditDTO<Long> {

    private Long userId;

    private Long goodsId;

    private GoodsDTO goods;

    private LocalDateTime triggerTime;

    private Integer amount;

    private FlashSaleStatusEnum status;

}