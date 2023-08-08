package lk.epic.customer_service.entity;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String customerId;
    private String name;
    private String address;
    private String email;
}
