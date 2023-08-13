package lk.epic.product_service.controller;

import lk.epic.product_service.dto.ProductDTO;
import lk.epic.product_service.entity.Product;
import lk.epic.product_service.repo.ProductRepo;
import lk.epic.product_service.service.ProductService;
import lk.epic.product_service.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
@RequiredArgsConstructor
@RefreshScope // To Refresh the Configuration properties in our services
// Whenever you call this controller which is annotated with this annotation
// it will basically refresh that particular bean and coming back to our endpoint
public class ProductController {
    private final ProductService productService;

    @Value("${test.name}")
    private String name;

    @GetMapping(path = "/test")
    public String test() {
        return name;
    }

    @GetMapping
    public ResponseEntity<ResponseUtil<List<Product>>> getAllProducts() {
        System.out.println("Hiiiiiiiiiiiiiiiiii...!");
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.getAllProducts());
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
