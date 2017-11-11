package be.cegeka.cleancode.domain.customers;

import be.cegeka.cleancode.Application;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@Transactional
public class CustomerRepositoryTest {

    @Inject
    private CustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private Customer nicky;
    private LoyaltyCard loyaltyCard;

    @Before
    public void setUp() throws Exception {
        nicky = new Customer("Nicky");
        loyaltyCard = new LoyaltyCard("barcode");
    }

    @Test
    public void addCustomer() throws Exception {
        customerRepository.addCustomer(nicky);
        Customer customer = entityManager.find(Customer.class, nicky.getId());
        assertThat(customer).isEqualTo(nicky);
    }



        @Test
    public void addLoyaltyCard_shouldAtLoyaltyCardtoCustomer() throws Exception {
        customerRepository.addCustomer(nicky);
        customerRepository.addLoyaltyCard(nicky.getId(), loyaltyCard);
        assertThat(loyaltyCard.getId()).isEqualTo(nicky.getLoyaltyCard().getId());

    }
        @Test
    public void addLoyaltyCard_shouldCreateALoyaltyCardInDataBase() throws Exception {
        customerRepository.addCustomer(nicky);
        customerRepository.addLoyaltyCard(nicky.getId(), loyaltyCard);
            assertThat(entityManager.find(LoyaltyCard.class, loyaltyCard.getId())).isEqualTo(loyaltyCard);
    }

    @Test
    public void searchCustomerByLoyaltyBarcode_shouldReturnACustomer_WithCorrespondingLoyaltyCard() throws Exception {
        customerRepository.addCustomer(nicky);
        customerRepository.addLoyaltyCard(nicky.getId(),loyaltyCard);
        assertThat(customerRepository.searchCustomerByLoyaltyBarcode(loyaltyCard.getBarcode())).containsExactly(nicky);
    }

    @After
    public void teardown() {
        entityManager.clear();
    }

}