package lk.epic.fraud_service.controller;

import lk.epic.fraud_service.dto.CustomerRegistrationRequestDTO;
import lk.epic.fraud_service.service.FraudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud")
@Slf4j // To log anything in our application into a terminal
public record FraudController(FraudService customerService) {
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequestDTO registrationRequest) {
        log.info("New Customer registration {}", registrationRequest);
        customerService.registerCustomer(registrationRequest);
    }
}
