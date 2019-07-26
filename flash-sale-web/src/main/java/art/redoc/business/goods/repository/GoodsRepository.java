package art.redoc.business.goods.repository;

import art.redoc.business.goods.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
