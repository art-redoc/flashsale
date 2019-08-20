package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.ChargeTypeEnum;
import art.redoc.business.goods.enums.ScenesTypeEnum;
import art.redoc.business.goods.enums.ValueTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity
public class ChargeConfig extends BaseModel {
    private static final long serialVersionUID = 8365710447780012662L;
    /**
     * 配置key
     */
    @Length(max = 40)
    private String configKey;
    /**
     * 配置value
     */
    @Length(max = 10)
    private String configValue;
    /**
     * value类型 百分数 / 值
     */
    @Enumerated(EnumType.STRING)
    private ValueTypeEnum valueType;
    /**
     * 费用产生场景 买卖/繁育 等
     */
    @Enumerated(EnumType.STRING)
    private ScenesTypeEnum scenesType;
    /**
     * 费用类型 官方收费/矿工费 等
     */
    @Enumerated(EnumType.STRING)
    private ChargeTypeEnum chargeType;
    /**
     * 描述
     */
    @Length(max = 200)
    private String description;
    /**
     * 是否正在使用 flag
     */
    @org.hibernate.annotations.Type(type = "yes_no")
    private Boolean current;
    /**
     * 最小值
     */
    @Length(max = 30)
    private String minValue;
    /**
     * 最大值
     */
    @Length(max = 30)
    private String maxValue;
}
