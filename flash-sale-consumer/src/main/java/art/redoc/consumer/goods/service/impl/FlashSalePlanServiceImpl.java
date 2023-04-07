package art.redoc.consumer.goods.service.impl;

import art.redoc.consumer.goods.repository.FlashSalePlanRepository;
import art.redoc.consumer.goods.service.FlashSalePlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FlashSalePlan service implement.
 *
 * @author code generator
 */
@Slf4j
@Service
public class FlashSalePlanServiceImpl implements FlashSalePlanService {

    @Autowired
    private FlashSalePlanRepository flashSalePlanRepository;

    @Override
    @Transactional
    public void updateStatusToFinishedAndAmountZero(Long id) {
        flashSalePlanRepository.updateStatusToFinishedAndAmountZero(id);
    }
}