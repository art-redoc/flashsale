package art.redoc.dto.goods.dto;

import art.redoc.core.dto.AbstractAuditDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsOrderDTO extends AbstractAuditDTO<Long> {

    private Long goodsId;
}