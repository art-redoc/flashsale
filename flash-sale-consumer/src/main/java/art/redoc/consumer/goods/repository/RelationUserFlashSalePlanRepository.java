package art.redoc.consumer.goods.repository;

import art.redoc.consumer.goods.model.RelationUserFlashSalePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Relation user flash sale plan repository.
 *
 * @author code generator
 */
public interface RelationUserFlashSalePlanRepository extends JpaRepository<RelationUserFlashSalePlan, Long> {

    List<RelationUserFlashSalePlan> findByFlashSalePlanId(Long flashSalePlanId);

    List<RelationUserFlashSalePlan> findByUserId(Long userId);
}
