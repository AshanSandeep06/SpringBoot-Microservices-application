package lk.epic.customer_service.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    private String customerId;
    private String name;
    private String address;
    private String email;
}
