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

/**
 * 守护类，只需要维护一个用户和宠物的关系
 *
 * @author sq
 * @date 2018/7/26 9:17
 */
@Entity
@Getter
@Setter
public class Guard extends BaseModel {
    private static final long serialVersionUID = 6520705392420410987L;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pet pet;
    @org.hibernate.annotations.Type(type = "yes_no")
    private Boolean currentFlag;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdventureAreaEnum area;


}