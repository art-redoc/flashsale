package art.redoc.business.goods.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import art.redoc.base.dto.AbstractAuditDTO;

@Getter
@Setter
public class GoodsDTO extends AbstractAuditDTO {

    @Length(max = 50)
    private String name;
}
