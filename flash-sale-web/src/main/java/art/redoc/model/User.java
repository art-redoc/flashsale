package art.redoc.model;

import art.redoc.base.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class User extends BaseModel {
    @Length(max = 50)
    private String name;
}
