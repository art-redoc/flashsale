package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 点赞表，宠物点赞明细，不能重复点赞，点赞后再次点赞则取消以前的点赞记录
 */

@Entity
@Getter
@Setter
public class Praise extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 2444811863062192219L;

    /**
     * 用户信息
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    /**
     * 宠物信息
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Pet pet;

}
