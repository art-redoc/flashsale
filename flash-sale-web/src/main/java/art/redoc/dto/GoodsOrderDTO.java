package art.redoc.dto;

import art.redoc.base.dto.AbstractAuditDTO;
import lombok.Getter;
import lombok.Setter;
import art.redoc.model.Goods;

@Getter
@Setter
public class GoodsOrderDTO extends AbstractAuditDTO {

    private Goods goods;
}
