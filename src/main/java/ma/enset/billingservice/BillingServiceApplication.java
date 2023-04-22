package ma.enset.billingservice;
import ma.enset.billingservice.entity.Bill;
import ma.enset.billingservice.entity.ProductItem;
import ma.enset.billingservice.feign.CustomerServiveClient;
import ma.enset.billingservice.feign.InventoryServiceClient;
import ma.enset.billingservice.model.Customer;
import ma.enset.billingservice.model.Product;
import ma.enset.billingservice.repository.BillRepository;
import ma.enset.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication implements CommandLineRunner {
	@Autowired private CustomerServiveClient customerServiveClient;
	@Autowired private InventoryServiceClient inventoryServiceClient;
	@Autowired private BillRepository billRepository;
	@Autowired private ProductItemRepository productItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = customerServiveClient.findCustomerById(1L);
		System.out.println(customer.toString());
		Product productById = inventoryServiceClient.findProductById(2L);
		System.out.print(productById.toString());
		List<ProductItem> allProductItems = productItemRepository.findAll();
		Bill bill = billRepository.save(new Bill(null, new Date(), customer.getId(), null, null));
		PagedModel<Product> products = inventoryServiceClient.findAll();
		for (Product product : products) {
			ProductItem productItem = new ProductItem();
			productItem.setProductId(product.getId());
			productItem.setPrice(product.getPrice());
			productItem.setQuantity((long) (Math.random()*10));
			productItem.setBill(bill);
			productItemRepository.save(productItem);

		}




	}
}