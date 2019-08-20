package art.redoc.business.goods.model;

import art.redoc.business.goods.enums.PetStatusEnum;
import art.redoc.business.goods.enums.SexEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import art.redoc.base.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 宠物表，用于记录宠物的详细信息。
 */

@Entity
@Getter
@Setter
@Table(indexes = {
        @Index(columnList = "serialno", name = "PET_SERIALNO_UNIQUEIDX", unique = true) ,
        @Index(columnList = "father_id", name = "PET_FATHERID_IDX"),
        @Index(columnList = "mother_id", name = "PET_MOTHERID_IDX") })
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer" })
public class Pet extends BaseModel {
    /**
     *
     */
    private static final long serialVersionUID = -8877674559639859853L;

    /**
     * 宠物编号
     */
    //    @Column(nullable = false)
    private Integer serialno;

    /**
     * 用户信息
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    /**
     * 属性信息
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pet")
    @JsonIgnore
    private List<PetAttribute> petAttribute = new ArrayList<>();

    /**
     * 挂单信息
     */
    @NotNull
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pet")
    @JsonIgnore
    private List<SaleAuction> saleAuctions = new ArrayList<>();

    /**
     * 生日日期
     */
    private Timestamp birthday;
    /**
     * 代数
     */
    private Integer generation;
    /**
     * 基因
     */
    @Length(max = 256)
    private String gene;

    /**
     * 体力
     */
    private Integer fatigue;

    /**
     * 星座
     */
    private Integer constellation;

    /**
     * 性别
     */
    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    /**
     * 父亲
     */
    @Column(name = "father_id")
    @Length(max = 32)
    private String fatherId;

    /**
     * 母亲
     */
    @Column(name = "mother_id")
    @Length(max = 32)
    private String motherId;

    /**
     * 状态：0正常，1提交挂单到售卖市场，2已挂单到销售市场，3提交繁育状态，4正繁育状态，
     * 5冷却状态，6提交提现状态，7提现状态，8等待挂单繁育市场，9已挂单到繁育市场 10提交赠送11赠送
     */
    @Enumerated(EnumType.STRING)
    private PetStatusEnum status;

    /**
     * 外观显性基因KAI值，用于检测外观基因是否唯一,在生成宠物时插入，不做修改
     */
    @Length(max = 10)
    @Column(length = 10)
    private String dominanceKai;

    /**
     * 描述
     */
    @Length(max = 300)
    @Column(length = 300)
    private String description;

    /**
     * 点赞数量
     */
    @Column(columnDefinition = "int default 0")
    private Integer praiseCount = 0;

    /**
     * 当前拍卖价格
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal currentSalePrice = BigDecimal.ZERO;

    /**
     * 当前繁育价格
     */
    @Column(columnDefinition = "decimal(30,6) default 0")
    private BigDecimal currentSiringPrice = BigDecimal.ZERO;

    /**
     * 吃货属性数量
     */
    private Integer foodieNumber;

    /**
     * 宠物名称
     */
    @Column(length = 40)
    private String petName;

    /**
     * 光环
     */
    private Integer halo;

    /**
     * 被限制时间
     */
    private Timestamp saleLimited;

}
