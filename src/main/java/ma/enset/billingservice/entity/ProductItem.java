package ma.enset.billingservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long productId;
    private double price;
    private int quantity;
    @ManyToOne
    private Bill bill;
}
