package ma.enset.billingservice.repository;

import ma.enset.billingservice.entity.ProductItem;
import ma.enset.billingservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
public interface ProductItemRepository  extends JpaRepository<ProductItem,Long> {
        List<ProductItem> findByBillId(long billId);
//
        List<ProductItem> findAll();
//        @GetMapping("/products")
//        Page<Product> pageProducts();
        /**Page<Product> pageProducts(@RequestParam(name = "page") int page
                , @RequestParam(name = "size") int size); **/


}