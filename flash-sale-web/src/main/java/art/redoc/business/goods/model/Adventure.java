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
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 宠物探险记录表，记录了每只宠物的探险记录，留存探险记录，使用currentFlag标识是否当前正在探险
 * @author sq
 * @date 2018/7/26 9:17
 */
@Entity
@Getter
@Setter
public class Adventure extends BaseModel {
    private static final long serialVersionUID = -6105658918399285142L;
    /**
     * 宠物信息
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Pet pet;

    /**
     * 探险地区
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdventureAreaEnum area;

    /**
     * 开始时间
     */
    private Timestamp startTime;

    /**
     * 结束时间
     */
    private Timestamp endTime;

    /**
     * 是否正在进行探险
     */
    @org.hibernate.annotations.Type(type = "yes_no")
    private Boolean currentFlag;

    /**
     * 探险取得的收益
     * @author sq
     * @param null
     * @return
     * @date 2018/7/27 15:09
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal income = BigDecimal.ZERO;
}
