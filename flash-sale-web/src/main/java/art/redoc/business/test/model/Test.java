package art.redoc.business.test.model;

import art.redoc.base.model.BaseModel;
import art.redoc.business.goods.model.Goods;
import art.redoc.business.goods.model.GoodsOrder;
import art.redoc.business.goods.model.User;
import art.redoc.business.test.enums.TestEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Test extends BaseModel {

    private static final long serialVersionUID = 1068092371106345380L;

    @Length(max = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    private TestEnum testEnum;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pet")
    @JsonIgnore
    @NotNull
    private List<Goods> goods = new ArrayList<>();

    @OneToOne
    @NotNull
    private GoodsOrder goodsOrder;

    @Column(name = "father_id")
    @Length(max = 32)
    private String fatherId;

    @Column(columnDefinition = "decimal(30,6)")
    private BigDecimal price;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @org.hibernate.annotations.Type(type = "yes_no")
    private Boolean isDefault;

    private Timestamp acceptTime;

    private LocalDateTime forbiddenTime;

    private Date localTime;
}
