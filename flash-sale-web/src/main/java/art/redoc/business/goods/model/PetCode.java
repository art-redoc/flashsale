package art.redoc.business.goods.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import art.redoc.base.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(indexes = {@Index(columnList = "used", name = "PETCODE_USED_IDX")})
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class PetCode extends BaseModel {
    
    private static final long serialVersionUID = 74833353324753341L;

    @OneToOne(fetch = FetchType.LAZY)
    private Pet pet;

    /**
     * 赠送码
     */
    @Length(max = 32)
    private String giftCode;

    /**
     * 是否已经被使用 1 是 0 否
     */
    @Column(columnDefinition = "int(2) default 0")
    private Integer used = 0;
    
}