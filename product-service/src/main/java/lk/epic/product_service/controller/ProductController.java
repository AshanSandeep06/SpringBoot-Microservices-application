package lk.epic.product_service.controller;

import lk.epic.product_service.dto.ProductDTO;
import lk.epic.product_service.entity.Product;
import lk.epic.product_service.repo.ProductRepo;
import lk.epic.product_service.service.ProductService;
import lk.epic.product_service.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<ResponseUtil<List<Product>>> getAllProducts() {
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
