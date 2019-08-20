package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.AdventureAreaEnum;
import art.redoc.business.goods.enums.AimTypeEnum;
import art.redoc.business.goods.enums.EventTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 探险随机事件的配置表
 *
 * @author sq
 * @date 2018/9/5 11:43
 */
@Entity
@Getter
@Setter
public class AdventureEvent extends BaseModel {

    /**
     * 目标类型：一只，多只，全部
     */
    @Enumerated(EnumType.STRING)
    private AimTypeEnum aimType;

    /**
     * 目标值，可存宠物id，具体数量，null，等
     */
    @Length(max = 32)
    private String aimValue;

    /**
     * 随机事件地点
     */
    @Enumerated(EnumType.STRING)
    private AdventureAreaEnum area;

    /**
     * 发生概率，百分数
     */
    @Column(columnDefinition = "decimal(10,4) default 0")
    private BigDecimal probability;

    /**
     * 触发开始时间
     */
    private Timestamp startTime;

    /**
     * 触发结束时间
     */
    private Timestamp endTime;

    /**
     * 事件类型，如体力，道具，空投ETH，空投BTC
     */
    @Enumerated(EnumType.STRING)
    private EventTypeEnum eventType;

    /**
     * 事件值，数字类型为 1，-1等，其他类型可填字符串，如道具中的挖矿手套
     */
    @Length(max = 150)
    private String eventValue;

    /**
     * 触发事件产生的描述
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
    
}
