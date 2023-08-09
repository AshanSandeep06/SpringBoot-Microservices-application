package lk.epic.fraud_service.controller;

import lk.epic.fraud_service.dto.FraudCheckResponse;
import lk.epic.fraud_service.service.FraudCheckService;
import lk.epic.fraud_service.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@Slf4j // To log anything in our application into a terminal
@CrossOrigin
public record FraudController(FraudCheckService fraudCheckService) {
    @GetMapping(path = "/{customerId}")
    public ResponseEntity<ResponseUtil<FraudCheckResponse>> isFraudster(@PathVariable String customerId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseUtil<>("00",
                        "Check whether the Customer is Fraudulent or not",
                        fraudCheckService.isFraudulentCustomer(customerId))
        );
    }
}
