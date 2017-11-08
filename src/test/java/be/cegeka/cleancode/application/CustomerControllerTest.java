package be.cegeka.cleancode.application;

import be.cegeka.cleancode.domain.customers.CustomerService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class CustomerControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Test
    public void addCustomer_shouldActivateCustomerService() throws Exception {
        customerController.addCustomer("Nicky");
        verify(customerService).addCustomer("Nicky");
    }
}