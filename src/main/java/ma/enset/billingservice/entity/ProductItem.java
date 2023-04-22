package ma.enset.billingservice.entity;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.billingservice.model.Product;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long productId;
    private double price;
    private long quantity;
    @ManyToOne
    private Bill bill;
    @Transient
    private Product product;

}