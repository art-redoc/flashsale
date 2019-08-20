package art.redoc.business.test.dto;

import art.redoc.base.dto.AbstractAuditDTO;

import art.redoc.business.test.enums.TestEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class TestDTO extends AbstractAuditDTO {

    private Long goodsId;

    private Long userId;

    private Long goodsOrderId;

    @Length(max = 50)
    private String name;

    private TestEnum testEnum;

    @Length(max = 32)
    private String fatherId;

    private BigDecimal price;

    private String content;

    @org.hibernate.annotations.Type(type = "yes_no")
    private Boolean isDefault;

    private Timestamp acceptTime;

    private LocalDateTime forbiddenTime;

    private Date localTime;

}