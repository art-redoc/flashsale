package redoc.sq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import redoc.sq.model.GoodsOrder;

public interface GoodsOrderRepository extends JpaRepository<GoodsOrder, String> {
}
