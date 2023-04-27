package ma.enset.billingservice.feign;
import ma.enset.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiveClient {
    @GetMapping("/customers/{id}?projection=fullCustomer")
    public Customer findCustomerById(@PathVariable(name ="id") long id);
    @GetMapping("/customers?projection=fullCustomer")
    PagedModel<Customer> findAll();
}