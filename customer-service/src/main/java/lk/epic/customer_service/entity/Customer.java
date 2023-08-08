package lk.epic.customer_service.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    // We give Sequence Generator for this property
    @SequenceGenerator(name = "customerId_sequence", sequenceName = "customerId_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerId_sequence")
    private Integer customerId;
    private String name;
    private String address;
    private String email;
}
