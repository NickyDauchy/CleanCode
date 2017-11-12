package be.cegeka.cleancode.domain.groceries;

import be.cegeka.cleancode.Application;
import be.cegeka.cleancode.domain.customers.Customer;
import be.cegeka.cleancode.domain.customers.CustomerRepository;
import be.cegeka.cleancode.domain.customers.LoyaltyCard;
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

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@Transactional
public class GroceryRepositoryTest {
    @Inject
    private GroceryRepository groceryRepository;

    @PersistenceContext
    private EntityManager entityManager;
    private Grocery grocery;
    private Customer customer;
    private GroceryOrder groceryOrder;

    @Before
    public void setUp() throws Exception {
        grocery = new Grocery("name",new BigDecimal(0.0));
        customer = new Customer("nicky");
        entityManager.persist(customer);
        groceryOrder = new GroceryOrder(customer,grocery,1);
    }

    @Test
    public void addGrocery() throws Exception {
        groceryRepository.addGrocery(grocery);

        assertThat(entityManager.find(Grocery.class, grocery.getId())).isEqualTo(grocery);
    }

    @Test
    public void buyGrocery() throws Exception {
        groceryRepository.addGrocery(grocery);
        groceryRepository.buyGrocery(groceryOrder);

        assertThat(entityManager.find(GroceryOrder.class, groceryOrder.getId())).isEqualTo(groceryOrder);
    }

}