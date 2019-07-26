package art.redoc.business.goods.dto;

import art.redoc.base.dto.AbstractAuditDTO;
import lombok.Getter;
import lombok.Setter;
import art.redoc.business.goods.model.Goods;

@Getter
@Setter
public class GoodsOrderDTO extends AbstractAuditDTO {

    private Goods goods;
}
