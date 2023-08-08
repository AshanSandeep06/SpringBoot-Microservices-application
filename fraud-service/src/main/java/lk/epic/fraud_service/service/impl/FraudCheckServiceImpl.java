package lk.epic.fraud_service.service.impl;

import lk.epic.fraud_service.repo.FraudRepo;
import lk.epic.fraud_service.service.FraudCheckService;
import org.springframework.stereotype.Service;

@Service
public record FraudCheckServiceImpl(FraudRepo fraudRepo) implements FraudCheckService {

}
