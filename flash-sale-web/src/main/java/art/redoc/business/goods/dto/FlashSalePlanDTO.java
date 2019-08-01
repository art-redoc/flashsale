package art.redoc.business.goods.dto;

import art.redoc.base.dto.AbstractAuditDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FlashSalePlanDTO extends AbstractAuditDTO {

    private Long goodsId;

    private LocalDateTime triggerTime;

    private Integer amount;

}