package ma.enset.billingservice.feign;

import ma.enset.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="INVENTORY-SERVICE")
public interface InventoryServiceClient{
    @GetMapping("/products/{id}?projection=fullProduct")
    Product findProductById(@PathVariable("id") Long id);
    @GetMapping("/products")
    List<Product> getProducts();
//    @GetMapping("/products?projection=fullProduct")
//    PagedModel<Product> pageProducts();

}