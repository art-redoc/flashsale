package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.CoinTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * ClassName: WalletAddress
 * Function: 钱包地址
 *
 * @author 刘伟
 * @date 2018年8月2日 上午11:19:09
 * @version V1.0.0
 */
@Entity
@Getter
@Setter
public class WalletAddress extends BaseModel {
    
    private static final long serialVersionUID = -6852752635080274475L;
    
    /**
     * 币种
     */
    @Enumerated(EnumType.STRING)
    private CoinTypeEnum coinType;

    /**
     * 钱包地址
     */
    @Length(max = 100)
    private String address;
    
    /**
     * 是否使用
     */
    private Boolean used = false;
}