package lk.epic.fraud_service.repo;

import lk.epic.fraud_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepo extends JpaRepository<Customer, Integer> {

}
