package be.cegeka.cleancode.domain.customers;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class CustomerServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void addCustomer_shouldActivateCustomerRepository() throws Exception {
        customerService.addCustomer("Nicky");
        verify(customerRepository).addCustomer(refEq(new Customer("Nicky")));
    }

    @Test
    public void addLoyaltyCard_shouldActivateCustomerRepository() throws Exception {
        customerService.addLoyaltyCard(1, "barcode");
        verify(customerRepository).addLoyaltyCard(eq(1), refEq(new LoyaltyCard("barcode")));
    }

    @Test
    public void searchCustomerByLoyaltyBarcode() throws Exception {
        customerService.searchCustomerByLoyaltyBarcode("barcode");
        verify(customerRepository).searchCustomerByLoyaltyBarcode("barcode");
    }
}