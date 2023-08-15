package lk.epic.customer_service.client;

import lk.epic.customer_service.dto.ProductDTO;
import lk.epic.customer_service.util.ResponseUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "product-service")
@Service
// Using this annotation spring will inject this product-service bean into our controller class
public interface ProductServiceClient {
    // create a http call
    // In Feign Client, spring will automatically generate the rqeuired
    // code for us(spring will automatically do it with help of annotations we are added)
    /*@GetMapping("/api/product")
    ResponseEntity<ResponseUtil<List<ProductDTO>>> getAllProducts();*/
}
