package lk.epic.product_service.service;

import lk.epic.product_service.dto.ProductDTO;
import lk.epic.product_service.entity.Product;
import lk.epic.product_service.util.ResponseUtil;

import java.util.List;

public interface ProductService {
    ResponseUtil<List<Product>> getAllProducts();
    ResponseUtil saveProduct(ProductDTO productDTO);
}
