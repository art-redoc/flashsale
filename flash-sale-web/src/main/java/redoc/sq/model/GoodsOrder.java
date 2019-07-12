package redoc.sq.model;

import lombok.Getter;
import lombok.Setter;
import redoc.sq.base.model.BaseModel;

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
