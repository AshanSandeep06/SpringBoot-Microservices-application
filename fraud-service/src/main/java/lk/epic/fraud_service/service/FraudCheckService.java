package lk.epic.fraud_service.service;

public interface FraudCheckService {
    boolean isFraudulentCustomer(Integer customerId);
}
