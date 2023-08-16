package lk.epic.product_service.controller;

import lk.epic.product_service.dto.ProductDTO;
import lk.epic.product_service.entity.Product;
import lk.epic.product_service.repo.ProductRepo;
import lk.epic.product_service.service.ProductService;
import lk.epic.product_service.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
@RequiredArgsConstructor
// We are going to inject resillence 4j circuit breaker factory class into our Controller class
//@RefreshScope // To Refresh the Configuration properties in our services
// Whenever you call this controller which is annotated with this annotation
// it will basically refresh that particular bean and coming back to our endpoint
public class ProductController {
    private final ProductService productService;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    @Value("${test.name}")
    private String name;

    @GetMapping(path = "/test")
    public String test() {
        return name;
    }

    @GetMapping
    public ResponseEntity<ResponseUtil<List<Product>>> getAllProducts() {
        Resilience4JCircuitBreaker circuitBreaker = circuitBreakerFactory.create("product-service");
        // Next we have to monitor this request
        Supplier<ResponseUtil<List<Product>>> supplierResponse = productService::getAllProducts;

        ResponseUtil<List<Product>> responseUtil = circuitBreaker.run(supplierResponse, (throwable) -> handleErrorCase());

        if (responseUtil != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(responseUtil);
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseUtil<>("06", "No Products Found..!", null));
        }
    }

    private ResponseUtil<List<Product>> handleErrorCase() {
        return new ResponseUtil<>("06", "No Products Found..!", null);
    }

    @PostMapping
    public ResponseEntity<ResponseUtil> createProduct(@RequestBody ProductDTO productDTO) {
        ResponseUtil response = productService.saveProduct(productDTO);
        if (response.getResponseCode().equals("00")) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
