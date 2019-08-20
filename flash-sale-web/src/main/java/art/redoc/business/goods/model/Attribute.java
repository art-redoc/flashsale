package art.redoc.business.goods.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.enums.PetAttributeTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 属性分类表
 */
@Entity
@Getter
@Setter
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Attribute extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = -4796912871086819091L;

    /**
     * 属性分类，例如（耳朵、身体、嘴巴）
     */
    @Enumerated(EnumType.STRING)
    private PetAttributeTypeEnum category;

    /**
     * 属性值
     */
    @Length(max = 10)
    private String attributeValue;

    /**
     * 属性对应的图片
     */
    @Length(max = 60)
    private String attributeImage;

    /**
     * 属性描述，例如红耳朵，绿耳朵
     */
    private String description;

    /**
     * 属性对应code
     */
    @Length(max = 10)
    private String code;

}
