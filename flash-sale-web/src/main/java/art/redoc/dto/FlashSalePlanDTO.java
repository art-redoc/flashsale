package art.redoc.dto;

import art.redoc.base.dto.AbstractAuditDTO;
import lombok.Getter;
import lombok.Setter;
import art.redoc.model.Goods;

import java.time.LocalDateTime;

@Getter
@Setter
public class FlashSalePlanDTO extends AbstractAuditDTO {

    private Goods goods;

    private LocalDateTime triggerTime;

    private Integer amount;
}
