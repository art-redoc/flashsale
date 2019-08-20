package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.AdventureAreaEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 探险随机事件的地点颜色配置表
 *
 * @author sq
 * @date 2018/9/5 11:43
 */
@Entity
@Getter
@Setter
@Table(indexes = {@Index(columnList = "area", name = "ADVENTUREEVENTAREACOLOR_AREA_UNIQUEIDX", unique = true)})
public class AdventureEventAreaColor extends BaseModel {

    /**
     * 随机事件地点
     */
    @Enumerated(EnumType.STRING)
    private AdventureAreaEnum area;

    /**
     * 事件颜色
     */
    @Length(max = 10)
    private String color;
    
}
