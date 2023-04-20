package ma.enset.billingservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateBilling;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
    private long customerId;
    @Transient
    private Customer customer;


}
