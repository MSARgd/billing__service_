package ma.enset.billingservice.web;

import ma.enset.billingservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryServiceClient {
    @GetMapping("/products/{id}?projection=fullProduct")
    Product findProductById(@PathVariable long id);

    @GetMapping("/products?projection=fullProduct")
    PagedModel<Product> findAll();
}