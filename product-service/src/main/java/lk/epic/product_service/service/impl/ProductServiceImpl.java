package lk.epic.product_service.service.impl;

import lk.epic.product_service.dto.ProductDTO;
import lk.epic.product_service.entity.Product;
import lk.epic.product_service.repo.ProductRepo;
import lk.epic.product_service.service.ProductService;
import lk.epic.product_service.util.ResponseUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public record ProductServiceImpl(ProductRepo productRepo) implements ProductService {
    @Override
    public ResponseUtil<List<Product>> getAllProducts() {
        List<Product> allProducts = productRepo.findAll();
        if (allProducts.size() > 0) {
            return new ResponseUtil<>("00", "Success", allProducts);
        }
        return new ResponseUtil<>("01", "No Products Found", null);
    }

    @Override
    public ResponseUtil saveProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .itemCode(productDTO.itemCode())
                .description(productDTO.description())
                .unitPrice(productDTO.unitPrice())
                .qtyOnHand(productDTO.qtyOnHand())
                .build();

        Product savedProduct = productRepo.save(product);
        if (savedProduct != null) {
            return new ResponseUtil<>("00", "Success", null);
        }
        return new ResponseUtil<>("01", "Product was not saved..!", null);
    }
}
