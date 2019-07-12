package redoc.sq.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Getter
@Setter
public class UserDTO extends AbstractAuditable {
    @Length(max = 50)
    private String name;
}
