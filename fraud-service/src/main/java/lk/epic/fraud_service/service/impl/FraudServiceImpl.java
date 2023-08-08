package lk.epic.fraud_service.service.impl;

import lk.epic.fraud_service.repo.FraudRepo;
import lk.epic.fraud_service.service.FraudService;
import org.springframework.stereotype.Service;

@Service
public record FraudServiceImpl(FraudRepo fraudRepo) implements FraudService {

}
