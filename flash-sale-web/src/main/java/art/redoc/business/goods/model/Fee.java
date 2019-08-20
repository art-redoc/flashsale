package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.CoinTypeEnum;
import art.redoc.business.goods.enums.FeeStateEnum;
import art.redoc.business.goods.enums.PetLifeTypeEnum;
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
 * 费用 记录表
 */
@Entity
@Getter
@Setter
@Table(indexes = {@Index(name = "FEE_TYPE_STATE_IDX", columnList = "type,state")})
public class Fee extends BaseModel {

    public Fee(){}
    public Fee(BigDecimal price, PetLifeTypeEnum type, String description, User user) {
        this.price = price;
        this.coinType = CoinTypeEnum.V钻;
        this.type = type;
        this.description = description;
        this.user = user;
    }
    public Fee(BigDecimal price, PetLifeTypeEnum type, String description, User user, CoinTypeEnum coinType) {
        this.price = price;
        this.coinType = CoinTypeEnum.V钻;
        this.type = type;
        this.description = description;
        this.user = user;
        this.coinType = coinType;
    }

    private static final long serialVersionUID = 6813769106071801676L;
    /**
     * 人员信息
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    /**
     * 买卖价格
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal price = BigDecimal.ZERO;

    /**
     * 服务费
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal serviceCharge = BigDecimal.ZERO;

    /**
     * 矿工费
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal minerFee = BigDecimal.ZERO;

    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal gasPrice = BigDecimal.ZERO;

    /**
     * 交易类型：买，卖，赠与，提取，提现
     */
    @Enumerated(EnumType.STRING)
    private PetLifeTypeEnum type;

    /**
     * 提款时的状态
     */
    @Enumerated(EnumType.STRING)
    private FeeStateEnum state;

    /**
     * 交易id
     */
    @Column(length = 70)
    private String txid;
    /**
     * 备注
     */
    private String description;

    @Enumerated(EnumType.STRING)
    private CoinTypeEnum coinType;

    /**
     * 审核失败原因
     */
//    private String auditFailedReason;

    /**
     * 交易发起方地址
     */
    @Column(length = 80)
    private String fromAddress;

    /**
     * 交易目标方
     */
    @Column(length = 80)
    private String toAddress;

}
