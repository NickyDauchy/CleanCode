package be.cegeka.cleancode.domain.customers;

import javax.inject.Inject;
import javax.inject.Named;

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
}
