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

		Bill bill = Bill.builder()
				.id(1L)
				.billingData(new Date((long) (Math.random()*System.currentTimeMillis())))
				.customerId(customer.getId())
				.customer(null)
				.productItems(null)
				.build();
		billRepository.save(bill);
		System.out.println(bill.toString());

		List<Product> productsModel  = inventoryServiceClient.getProducts();
		productsModel.forEach(p->{
			ProductItem productItem = ProductItem.builder()
					.productId(p.getId())
					.bill(bill)
					.product(p)
					.quantity((long) (Math.random()*10))
					.price(p.getPrice())
					.build();
			System.out.println(productItem.toString());
			 productItemRepository.save(productItem);
		});

	}
}