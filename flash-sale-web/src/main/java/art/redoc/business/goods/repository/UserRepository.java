package art.redoc.business.goods.repository;

import art.redoc.business.goods.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
