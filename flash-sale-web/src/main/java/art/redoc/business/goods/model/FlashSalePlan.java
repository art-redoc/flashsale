package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class FlashSalePlan extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    private Goods goods;

    private LocalDateTime triggerTime;

    private Integer amount;
}
