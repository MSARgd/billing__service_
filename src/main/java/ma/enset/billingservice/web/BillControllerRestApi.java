package ma.enset.billingservice.web;
import ma.enset.billingservice.entity.Bill;
import ma.enset.billingservice.feign.CustomerServiveClient;
import ma.enset.billingservice.feign.InventoryServiceClient;
import ma.enset.billingservice.repository.BillRepository;
import ma.enset.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
@RestController
public class BillControllerRestApi {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private InventoryServiceClient inventoryServiceClient;
    @Autowired
    private CustomerServiveClient customerServiveClient;
//    @GetMapping("/billes/{id}")
//    private Optional<Bill> getBill(@PathVariable("id") long id){
//        Bill bill = billRepository.findById(id).get();
//        bill.setCustomer(customerServiveClient.findCustomerById(bill.getCustomerId()));
//        bill.setProductItems(productItemRepository.findBillById(id));
//        bill.getProductItems().forEach(p->{
//            p.setProduct(inventoryServiceClient.findProductById(p.getProductId()));
//        });
//        return Optional.ofNullable(Optional.of(bill).orElseThrow(() -> new IllegalArgumentException("")));
//    }
    @GetMapping("/bills/{id}")
    private Optional<Bill> getBill(@PathVariable("id") long id){
        Bill bill = billRepository.findById(id).get();
        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.setCustomer(customerServiveClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(p -> {
            p.setProduct(inventoryServiceClient.findProductById(p.getProductId()));
        });
        return Optional.ofNullable(Optional.of(bill)
                .orElseThrow(() -> new IllegalArgumentException("Invalide id" + id)));
    }
}