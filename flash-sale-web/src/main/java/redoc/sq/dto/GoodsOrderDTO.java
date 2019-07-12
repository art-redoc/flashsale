package redoc.sq.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;
import redoc.sq.model.Goods;

@Getter
@Setter
public class GoodsOrderDTO extends AbstractAuditable {

    private Goods goods;
}
