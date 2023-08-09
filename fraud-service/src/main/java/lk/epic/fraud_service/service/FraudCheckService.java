package lk.epic.fraud_service.service;

import lk.epic.fraud_service.dto.FraudCheckResponse;

public interface FraudCheckService {
    FraudCheckResponse isFraudulentCustomer(String customerId);
}
