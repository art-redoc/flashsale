package redoc.sq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import redoc.sq.model.Goods;

public interface GoodsRepository extends JpaRepository<Goods, String> {
}
