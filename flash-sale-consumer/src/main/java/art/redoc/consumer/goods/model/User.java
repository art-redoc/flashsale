package art.redoc.consumer.goods.model;

import art.redoc.consumer.base.model.BaseModel;
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
