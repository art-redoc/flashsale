package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.CoinTypeEnum;
import art.redoc.business.goods.enums.FeeStateEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 提币
 */
@Entity
@Getter
@Setter
@Table(indexes = {@Index(columnList = "finished", name = "WITHDRAW_FINISHED_UNIQUEIDX")})
public class Withdraw extends BaseModel {

    private static final long serialVersionUID = -1638776539742065957L;

    /**
     * 用户信息
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    
    /**
     * 提币地址
     */
    @Column(length = 70)
    private String toAddress;

    /**
     * 用户钱包地址
     */
    @Column(length = 70)
    private String fromAddress;
    
    /**
     * 币种
     */
    @Enumerated(EnumType.STRING)
    private CoinTypeEnum coinType;
    
    /**
     * 提币金额
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal amount;
    
    /**
     * 手续费
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal serviceCharge;
    
    /**
     * 交易hash
     */
    @Column(length = 70)
    private String txid;
    
    /**
     * 提币状态
     */
    @Enumerated(EnumType.STRING)
    private FeeStateEnum state;
    
    /**
     * 是否处理结束
     */
    private Boolean finished;

    /**
     * 审核失败原因
     */
    private String auditFailedReason;
}
