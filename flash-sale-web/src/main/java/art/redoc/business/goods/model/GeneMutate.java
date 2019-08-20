package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.PetAttributeTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class GeneMutate extends BaseModel implements Serializable {

    private static final long serialVersionUID = -4915688387641309261L;
    /**
     * 属性分类，例如（耳朵、身体、嘴巴）
     */
    @Enumerated(EnumType.STRING)
    private PetAttributeTypeEnum category;

    /**
     * 父亲基因
     */
    @Length(max = 900)
    private String geneFather;

    /**
     * 母亲基因
     */
    @Length(max = 900)
    private String geneMother;

    /**
     * 突变基因code
     */
    @Length(max = 10)
    private String mutateCode;

    /**
     * 突变概率
     */
    private Integer probability;

    @Override
    public String toString() {
        return "GeneMutate{" +
                "category=" + category +
                ", geneFather='" + geneFather + '\'' +
                ", geneMother='" + geneMother + '\'' +
                ", mutateCode='" + mutateCode + '\'' +
                ", probability=" + probability +
                '}';
    }
}
