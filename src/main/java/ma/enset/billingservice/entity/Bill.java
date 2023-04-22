package ma.enset.billingservice.entity;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.billingservice.entity.ProductItem;
import ma.enset.billingservice.model.Customer;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingData;
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy ="bill")
    private Collection<ProductItem> productItems;






}