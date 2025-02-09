package lk.epic.fraud_service.service.impl;

import lk.epic.fraud_service.dto.FraudCheckResponse;
import lk.epic.fraud_service.entity.FraudCheckHistory;
import lk.epic.fraud_service.repo.FraudRepo;
import lk.epic.fraud_service.service.FraudCheckService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckServiceImpl(FraudRepo fraudRepo) implements FraudCheckService {
    @Override
    public FraudCheckResponse isFraudulentCustomer(String customerId) {
        fraudRepo.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return new FraudCheckResponse(false);
    }
}
