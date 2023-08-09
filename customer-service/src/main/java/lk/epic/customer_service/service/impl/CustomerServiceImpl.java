package lk.epic.customer_service.service.impl;

import lk.epic.customer_service.dto.CustomerRegistrationRequestDTO;
import lk.epic.customer_service.dto.FraudCheckResponse;
import lk.epic.customer_service.entity.Customer;
import lk.epic.customer_service.repo.CustomerRepo;
import lk.epic.customer_service.service.CustomerService;
import lk.epic.customer_service.util.ResponseUtil;
import lombok.NonNull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
// We can inject CustomerRepo interface's bean just like this
// We don't need @Autowired annotation for that
// Because we're using a record
public record CustomerServiceImpl(CustomerRepo customerRepo, RestTemplate restTemplate) implements CustomerService {
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

        // We use saveAndFlush() method in here.
        if (!customerRepo.existsById(customer.getCustomerId())) {
            if (customerRepo.save(customer) != null) {
                ResponseEntity<ResponseUtil<FraudCheckResponse>> responseEntity = restTemplate.exchange(
                        "http://FRAUD-SERVICE/api/v1/fraud-check/{customerId}",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ResponseUtil<FraudCheckResponse>>() {
                        },
                        customer.getCustomerId()
                );

                ResponseUtil<FraudCheckResponse> response = responseEntity.getBody();

                assert response != null;
                FraudCheckResponse fraudCheckResponse = response.getContent();
                if (fraudCheckResponse != null && fraudCheckResponse.isFraudster()) {
                    throw new RuntimeException("This Customer - " + customer.getCustomerId() + " is a Fraudster..!");
                }
            } else {
                throw new RuntimeException("Customer is failed to persist");
            }
        } else {
            throw new RuntimeException("This Customer is already exists..!");
        }
    }
}
