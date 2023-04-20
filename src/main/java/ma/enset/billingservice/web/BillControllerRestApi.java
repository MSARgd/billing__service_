package ma.enset.billingservice.web;

import ma.enset.billingservice.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillControllerRestApi {
    @Autowired
    private BillRepository billRepository;

}
