package art.redoc.business.goods.repository;

import art.redoc.business.goods.model.FlashSalePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * FlashSalePlan repository.
 *
 * @author code generator
 */
public interface FlashSalePlanRepository extends JpaRepository<FlashSalePlan, Long> {

    List<FlashSalePlan> findByGoodsId(String id);

}