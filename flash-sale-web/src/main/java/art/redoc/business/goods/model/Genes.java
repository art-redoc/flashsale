package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 基因表，存储零代宠物基因
 */

@Entity
@Getter
@Setter
public class Genes extends BaseModel {
    /**
     *
     */
    private static final long serialVersionUID = -5529175552195167225L;

    /**
     * 基因
     */
    @Column(length = 256)
    private String gene;

    /**
     * 状态 未生成宠物，已经生成宠物
     */
    private Integer state;
}
