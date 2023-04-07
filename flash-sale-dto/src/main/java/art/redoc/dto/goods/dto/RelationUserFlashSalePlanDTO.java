package art.redoc.dto.goods.dto;

import art.redoc.core.dto.AbstractAuditDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Relation user flash sale plan DTO.
 *
 * @author code generator
 */
@Getter
@Setter
public class RelationUserFlashSalePlanDTO extends AbstractAuditDTO<Long> {

    private Long flashSalePlanId;

    private Long userId;
}
