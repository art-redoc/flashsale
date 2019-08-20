package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.PetAttributeTypeEnum;
import art.redoc.business.goods.enums.TypeCatalogEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class PetTalk extends BaseModel {


    /**
     *
     */
    private static final long serialVersionUID = -7804486668989325907L;


    @Enumerated(EnumType.STRING)
    private TypeCatalogEnum typeCatalog;


    /**
     * 存放外观的分类（耳朵、鼻子、眼睛等）
     */
    @Enumerated(EnumType.STRING)
    private PetAttributeTypeEnum typeItem;

    /**
     * 存放外观的值或者星座的value、状态的value，状态的value除了宠物市场、繁殖育场TV宝宝，挖矿以外，均算作正常状态
     */
    @Length(max = 50)
    private String itemValue;


    @Length(max = 100)
    private String message;

}
