package art.redoc.consumer.goods.model;

import art.redoc.consumer.base.model.BaseModel;
import art.redoc.dto.goods.enums.FlashSaleStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class FlashSalePlan extends BaseModel {

    private Long goodsId;

    private LocalDateTime triggerTime;

    private Integer amount;

    @Enumerated(EnumType.STRING)
    private FlashSaleStatusEnum status = FlashSaleStatusEnum.PENDING;

}
