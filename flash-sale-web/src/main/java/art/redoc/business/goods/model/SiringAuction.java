package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 繁育市场表，用于存储挂单到繁育市场的宠物信息。
 */

@Entity
@Getter
@Setter
public class SiringAuction extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 5820889163463887924L;

    /**
     * 宠物信息
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Pet pet;

    /**
     * 开始时间
     */
    private Timestamp startTime;

    /**
     * 结束时间
     */
    private Timestamp endTime;

    /**
     * 开始价格
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal startPrice = BigDecimal.ZERO;
    /**
     * 结束价格
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal endPrice = BigDecimal.ZERO;

    /**
     * 持续时间（以天为单位）
     */
    private Integer durativeTime;

    /**
     * 服务费
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal serviceCharge = BigDecimal.ZERO;

    /**
     * 当前价格
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal currentPrice = BigDecimal.ZERO;

    /**
     * 当前宠物的最新价格数据
     */
    private Boolean currentFlag;
}
