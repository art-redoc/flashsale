package redoc.sq.base.model;

import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import redoc.sq.model.User;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Setter
public class BaseModel extends AbstractGeneralModel<User, String> {

    @Id
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDHexGenerator")
    @GeneratedValue(generator = "jpa-uuid")
    @Length(max = 32)
    private String id;

    @Override
    public String getId() {
        return this.id;
    }
}
