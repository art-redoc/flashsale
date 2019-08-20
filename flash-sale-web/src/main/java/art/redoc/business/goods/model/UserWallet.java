package art.redoc.business.goods.model;


import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.CoinTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * ClassName: UserWallet
 * Function: 用户钱包
 *
 * @author 刘伟
 * @date 2018年8月2日 上午11:19:35
 * @version V1.0.0
 */
@Entity
@Getter
@Setter
@Table(indexes = {
        @Index(columnList = "user_id, coinType", name = "USERWALLET_USERID_COINTYPE_UNIQUEIDX", unique = true),
        @Index(columnList = "address, coinType", name = "USERWALLET_ADDRESS_COINTYPE_UNIQUEIDX", unique = true)})
public class UserWallet extends BaseModel {
    
    private static final long serialVersionUID = -1027724644274206620L;

    /**
     * 用户信息
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    /**
     * 币种
     */
    @Enumerated(EnumType.STRING)
    private CoinTypeEnum coinType;

    /**
     * 正常账户余额
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal balance = BigDecimal.ZERO;

    /**
     * 冻结账户余额
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal freeze = BigDecimal.ZERO;

    /**
     * 钱包地址
     */
    @Length(max = 100)
    private String address;
    
    /**
     * 外部钱包地址
     */
    @Length(max = 80)
    private String extAddress;
}