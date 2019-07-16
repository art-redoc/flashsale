package art.redoc.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Getter
@Setter
public abstract class AbstractAuditDTO extends AbstractAuditable {

    @JsonIgnore
    @Override
    public boolean isNew() {
        return super.isNew();
    }

    private Long id;
}
