package art.redoc.dto.goods.dto;

import art.redoc.core.dto.AbstractAuditDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class GoodsDTO extends AbstractAuditDTO<Long> {

    @Length(max = 50)
    private String name;

}