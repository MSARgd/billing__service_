package ma.enset.billingservice.entity;

import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Customer {
    private long id;
    private String name;
    private  String email;


}