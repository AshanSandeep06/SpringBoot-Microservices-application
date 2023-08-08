package lk.epic.fraud_service.repo;

import lk.epic.fraud_service.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepo extends JpaRepository<FraudCheckHistory, Integer> {

}
