package lk.epic.product_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Define this Product class as a Mongodb Document(Table)
@Document(value = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Product {
    @Id
    private String itemCode;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}
