package lk.epic.customer_service.service.impl;

import lk.epic.customer_service.dto.CustomerRegistrationRequestDTO;
import lk.epic.customer_service.entity.Customer;
import lk.epic.customer_service.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl() implements CustomerService {
    @Override
    public void registerCustomer(CustomerRegistrationRequestDTO registrationRequest) {
        Customer customer = Customer.builder()
                .customerId(registrationRequest.customerId())
                .name(registrationRequest.name())
                .address(registrationRequest.address())
                .email(registrationRequest.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        // todo: store customer in db
    }
}
