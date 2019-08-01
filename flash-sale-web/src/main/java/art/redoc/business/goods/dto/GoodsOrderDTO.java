package art.redoc.business.goods.dto;

import art.redoc.base.dto.AbstractAuditDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsOrderDTO extends AbstractAuditDTO {

    private Long goodsId;
}