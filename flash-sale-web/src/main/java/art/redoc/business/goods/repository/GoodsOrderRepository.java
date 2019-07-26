package art.redoc.business.goods.repository;

import art.redoc.business.goods.model.GoodsOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsOrderRepository extends JpaRepository<GoodsOrder, Long> {
}
