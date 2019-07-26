package art.redoc.base.model;

import art.redoc.core.model.AbstractGeneralModel;
import art.redoc.business.goods.model.User;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel extends AbstractGeneralModel<User, Long> {

    @Id
    @GenericGenerator(name = "snow-flake", strategy = "art.redoc.base.model.GeneralIDGenerator")
    @GeneratedValue(generator = "snow-flake")
    @Setter
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }
}
