package lk.epic.customer_service.service;

import lk.epic.customer_service.dto.CustomerRegistrationRequestDTO;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequestDTO registrationRequest);
}
