package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class GoodsOrder extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    private Goods goods;
}
