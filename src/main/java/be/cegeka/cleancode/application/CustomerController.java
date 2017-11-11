package be.cegeka.cleancode.application;

import be.cegeka.cleancode.domain.customers.Customer;
import be.cegeka.cleancode.domain.customers.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

import javax.inject.Inject;
import java.awt.*;
import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping(path = "/customer")
@Transactional
public class CustomerController {
    @Inject
    private CustomerService customerService;

    @PostMapping
    public void addCustomer(@RequestParam(value = "name", required = true) String name) {
        customerService.addCustomer(name);
    }

    @PostMapping(path = "/loyalty")
    public void addLoyaltyCard(@RequestParam(value = "customerId", required = true) int customerid,
                               @RequestParam(value = "barcode", required = true) String barcode
    ) {
        customerService.addLoyaltyCard(customerid, barcode);

    }

    @GetMapping(path = "/searchCustomerByLoyaltyBarcode")
    public List<Customer> searchCustomerByLoyaltyBarcode(@RequestParam(value= "barcode",required = true)String barcode){
return customerService.searchCustomerByLoyaltyBarcode(barcode);
    }

}
