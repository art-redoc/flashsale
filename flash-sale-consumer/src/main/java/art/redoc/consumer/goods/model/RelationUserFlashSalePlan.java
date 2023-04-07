package art.redoc.consumer.goods.model;

import art.redoc.consumer.base.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class RelationUserFlashSalePlan extends BaseModel {

    private Long userId;
    private Long flashSalePlanId;
}
