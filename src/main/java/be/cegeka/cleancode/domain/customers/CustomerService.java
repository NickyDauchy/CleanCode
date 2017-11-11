package be.cegeka.cleancode.domain.customers;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Named
public class CustomerService {
    @Inject
    private CustomerRepository customerRepository;

    public void addCustomer(String name) {
        customerRepository.addCustomer(new Customer(name));
    }

    public void addLoyaltyCard(int customerid, String barcode) {
        customerRepository.addLoyaltyCard(customerid,new LoyaltyCard(barcode));
    }

    public List<Customer> searchCustomerByLoyaltyBarcode(String barcode) {
    return customerRepository.searchCustomerByLoyaltyBarcode(barcode);}
}
