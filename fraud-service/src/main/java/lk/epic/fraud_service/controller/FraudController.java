package lk.epic.fraud_service.controller;

import lk.epic.fraud_service.service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud")
@Slf4j // To log anything in our application into a terminal
@CrossOrigin
public record FraudController(FraudCheckService fraudCheckService) {

}
