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
 * 宠物繁育表，用于存储交配状态信息。
 */

@Entity
@Getter
@Setter

public class Siring extends BaseModel {
    /**
     *
     */
    private static final long serialVersionUID = -3387825871309892285L;

    /**
     * 用户信息
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    /**
     * 雄性宠物信息
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Pet petMale;

    /**
     * 雌性宠物信息
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Pet petFemale;

    /**
     * 我的宠物id 确认1 2哪个是我的
     */
    private String myPetId;

    private String otherPetId;

    /**
     * 开始时间
     */
    private Timestamp startTime;

    /**
     * 结束时间
     */
    private Timestamp endTime;

    /**
     * 手续费
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal serviceCharge = BigDecimal.ZERO;

    /**
     * 交配结果 1 成功 0 失败
     */
    private Integer result;
}
