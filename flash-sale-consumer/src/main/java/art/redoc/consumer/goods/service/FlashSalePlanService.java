package art.redoc.consumer.goods.service;

import art.redoc.consumer.goods.model.FlashSalePlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * FlashSalePlan service.
 *
 * @author code generator
 */
public interface FlashSalePlanService {

    void updateStatusToFinishedAndAmountZero(Long id);
}