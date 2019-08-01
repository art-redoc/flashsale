package art.redoc.business.goods.repository;

import art.redoc.business.goods.model.GoodsOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * GoodsOrder repository.
 *
 * @author code generator
 */
public interface GoodsOrderRepository extends JpaRepository<GoodsOrder, Long> {

    List<GoodsOrder> findByGoodsId(String id);

}