package lk.epic.customer_service.controller;

import lk.epic.customer_service.dto.CustomerRegistrationRequestDTO;
import lk.epic.customer_service.service.CustomerService;
import lk.epic.customer_service.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@Slf4j // To log anything in our application into a terminal
public record CustomerController(CustomerService customerService) {
    @PostMapping
    public ResponseEntity<ResponseUtil<?>> registerCustomer(@RequestBody CustomerRegistrationRequestDTO registrationRequest) {
        log.info("New Customer registration {}", registrationRequest);
        customerService.registerCustomer(registrationRequest);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseUtil<>("00", "Customer Registration was Successfully", null)
        );
    }
}
