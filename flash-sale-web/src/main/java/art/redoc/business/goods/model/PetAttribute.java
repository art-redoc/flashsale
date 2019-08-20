package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * 宠物属性与人员关系表，用于展示和维护菲力图鉴功能。
 */

@Entity
@Getter
@Setter
public class PetAttribute extends BaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = -2202802761869762502L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY)
    private Attribute attribute;
}