package art.redoc.business.goods.dto;

import art.redoc.base.dto.AbstractAuditDTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class GoodsDTO extends AbstractAuditDTO {

    @Length(max = 50)
    private String name;

}