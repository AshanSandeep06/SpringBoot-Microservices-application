package lk.epic.fraud_service.service;

import lk.epic.fraud_service.dto.CustomerRegistrationRequestDTO;

public interface FraudService {
    void registerCustomer(CustomerRegistrationRequestDTO registrationRequest);
}
