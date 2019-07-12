package redoc.sq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import redoc.sq.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
