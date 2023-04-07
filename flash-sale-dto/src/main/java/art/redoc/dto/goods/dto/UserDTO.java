package art.redoc.dto.goods.dto;

import art.redoc.core.dto.AbstractAuditDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * User DTO.
 *
 * @author code generator
 */
@Getter
@Setter
public class UserDTO extends AbstractAuditDTO<Long> {
    @Length(max = 50)
    private String name;
}
