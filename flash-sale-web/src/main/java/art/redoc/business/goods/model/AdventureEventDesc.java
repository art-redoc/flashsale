package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.AdventureAreaEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * 宠物遇到随机事件详情
 *
 * @author sq
 * @date 2018/9/5 11:43
 */
@Entity
@Getter
@Setter
public class AdventureEventDesc extends BaseModel {
    private static final long serialVersionUID = 1338435309434305254L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY)
    private AdventureEvent event;

    /**
     * 触发时间
     */
    private Timestamp triggerTime;

    /**
     * 随机事件地点
     */
    @Enumerated(EnumType.STRING)
    private AdventureAreaEnum area;

    /**
     * 事件描述
     */
    @Length(max = 200)
    private String description;
    
    /**
     * 图片URL
     */
    @Length(max = 256)
    private String imageUrl;
    
    /**
     * 事件标题
     */
    @Length(max = 100)
    private String eventTitle;
    
    /**
     * 事件结果
     */
    @Length(max = 100)
    private String eventResult;

    /**
     * 事件颜色
     */
    @Length(max = 10)
    private String eventColor;

    /**
     * 事件地点颜色
     */
    @Length(max = 10)
    private String areaColor;
    
}