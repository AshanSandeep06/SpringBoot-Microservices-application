package lk.epic.fraud_service.service.impl;

import lk.epic.fraud_service.dto.CustomerRegistrationRequestDTO;
import lk.epic.fraud_service.entity.Customer;
import lk.epic.fraud_service.repo.FraudRepo;
import lk.epic.fraud_service.service.FraudService;
import org.springframework.stereotype.Service;

@Service
public record FraudServiceImpl(FraudRepo fraudRepo) implements FraudService {
    @Override
    public void registerCustomer(CustomerRegistrationRequestDTO registrationRequest) {
        Customer customer = Customer.builder()
                .name(registrationRequest.name())
                .address(registrationRequest.address())
                .email(registrationRequest.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        // todo: store customer in db
        fraudRepo.save(customer);
    }
}
