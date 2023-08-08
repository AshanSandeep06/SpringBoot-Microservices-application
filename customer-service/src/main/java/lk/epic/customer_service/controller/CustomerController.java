package lk.epic.customer_service.controller;

import lk.epic.customer_service.dto.CustomerRegistrationRequestDTO;
import lk.epic.customer_service.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@Slf4j // To log anything in our application into a terminal
public record CustomerController(CustomerService customerService) {
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequestDTO registrationRequest) {
        log.info("New Customer registration {}", registrationRequest);
        customerService.registerCustomer(registrationRequest);
    }
}
