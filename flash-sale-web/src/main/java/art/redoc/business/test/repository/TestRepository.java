package art.redoc.business.test.repository;

import art.redoc.business.test.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TestRepository
 */
public interface TestRepository extends JpaRepository<Test, Long> {

    Test findByGoodsOrderId(String id);

    List<Test> findByUserId(String id);

}