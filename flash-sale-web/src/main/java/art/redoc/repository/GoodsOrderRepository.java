package art.redoc.repository;

import art.redoc.model.GoodsOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsOrderRepository extends JpaRepository<GoodsOrder, Long> {
}
