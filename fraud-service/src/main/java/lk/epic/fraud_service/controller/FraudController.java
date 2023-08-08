package lk.epic.fraud_service.controller;

import lk.epic.fraud_service.dto.FraudCheckResponse;
import lk.epic.fraud_service.service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@Slf4j // To log anything in our application into a terminal
@CrossOrigin
public record FraudController(FraudCheckService fraudCheckService) {
    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
    }
}
