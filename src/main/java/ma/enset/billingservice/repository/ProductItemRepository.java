package ma.enset.billingservice.repository;

import ma.enset.billingservice.entity.Product;
import ma.enset.billingservice.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductItemRepository  extends JpaRepository<ProductItem,Long> {
        List<ProductItem> findAll();
//        ProductItem findProductItemByBillId(long billID);
}