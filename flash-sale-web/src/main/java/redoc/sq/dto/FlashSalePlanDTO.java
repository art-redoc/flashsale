package redoc.sq.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;
import redoc.sq.base.dto.AbstractAuditDTO;
import redoc.sq.model.Goods;

import java.time.LocalDateTime;

@Getter
@Setter
public class FlashSalePlanDTO extends AbstractAuditable {

    private Goods goods;

    private LocalDateTime triggerTime;

    private Integer amount;
}
