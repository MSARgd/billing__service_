package ma.enset.billingservice.repository;
import ma.enset.billingservice.entity.ProductItem;
import ma.enset.billingservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.Collection;
import java.util.List;
@RepositoryRestResource
public interface ProductItemRepository  extends JpaRepository<ProductItem,Long> {
        public List<ProductItem> findByBillId(long billId);
        public List<ProductItem> findAll();
//        public List<Product> pageProducts();
}