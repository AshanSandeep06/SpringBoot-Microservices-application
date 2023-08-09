package lk.epic.customer_service.service;

import lk.epic.customer_service.dto.CustomerRegistrationRequestDTO;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequestDTO registrationRequest);
}
