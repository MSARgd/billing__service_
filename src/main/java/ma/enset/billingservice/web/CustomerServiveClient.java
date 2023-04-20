package ma.enset.billingservice.web;

import ma.enset.billingservice.entity.Customer;
import ma.enset.billingservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerServiveClient {
    @GetMapping("/customers/{id}?projection=fullCustomer")
    Customer findCustomerById(@PathVariable long id);

    @GetMapping("/customers?projection=fullCustomer")
    PagedModel<Customer> findAll();

}