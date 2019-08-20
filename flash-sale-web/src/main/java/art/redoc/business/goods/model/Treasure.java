package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.AdventureAreaEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

/**
 * 没宠物的用户埋藏宝藏记录
 * @author sq
 * @date 2018/7/26 9:23
 */
@Entity
@Getter
@Setter
public class Treasure extends BaseModel {

    private static final long serialVersionUID = 8883216917715717982L;
    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdventureAreaEnum area;

    /**
     * 是否被守护
     */
    @org.hibernate.annotations.Type(type = "yes_no")
    private Boolean isGuard = false;
}