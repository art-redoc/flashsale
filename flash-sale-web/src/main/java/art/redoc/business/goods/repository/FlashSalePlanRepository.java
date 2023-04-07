package art.redoc.business.goods.repository;

import art.redoc.business.goods.model.FlashSalePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * FlashSalePlan repository.
 *
 * @author code generator
 */
public interface FlashSalePlanRepository extends JpaRepository<FlashSalePlan, Long> {

    List<FlashSalePlan> findByGoodsId(String id);

    @Modifying
    @Query(value = " update flash_sale_plan set status = 'FINISHED', amount = 0 where id = (?1)", nativeQuery = true)
    void updateStatusToFinishedAndAmountZero(Long id);
}