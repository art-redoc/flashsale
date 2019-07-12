package redoc.sq.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import redoc.sq.base.model.BaseModel;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Goods extends BaseModel {

    @Length(max = 50)
    private String name;
}
