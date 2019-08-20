package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.CoinTypeEnum;
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
 * 用户充值记录
 */
@Entity
@Getter
@Setter
@Table(indexes = {
        @Index(columnList = "txid, coinType", name = "DEPOSIT_TXID_COINTYPE_UNIQUEIDX", unique = true),
        @Index(columnList = "coinType", name = "DEPOSIT_COINTYPE_UNIQUEIDX")})
public class Deposit extends BaseModel {

    private static final long serialVersionUID = 603057848995036291L;
    
    /**
     * 用户信息
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    
    /**
     * 充币地址
     */
    @Column(nullable = false, length = 70)
    private String addressTo;

    /**
     * 充币地址
     */
    @Column(nullable = false, length = 70)
    private String addressFrom;

    /**
     * 交易hash
     */
    @Column(nullable = false, length = 70)
    private String txid;
    
    /**
     * 充币金额
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal amount;

    /**
     * 币种
     */
    @Enumerated(EnumType.STRING)
    private CoinTypeEnum coinType;
}
