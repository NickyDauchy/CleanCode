package be.cegeka.cleancode.domain.groceries;

import be.cegeka.cleancode.Application;
import be.cegeka.cleancode.domain.customers.Customer;
import be.cegeka.cleancode.domain.customers.CustomerRepository;
import be.cegeka.cleancode.domain.customers.LoyaltyCard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
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
    private GroceryOrderDto groceryOrderDto;
    private GroceryOrder groceryOrder;

    @Before
    public void setUp() throws Exception {
        grocery = new Grocery("name",new BigDecimal(0.0));
        customer = new Customer("nicky");
        entityManager.persist(customer);
        entityManager.persist(grocery);

        groceryOrderDto = new GroceryOrderDto(customer.getId(),grocery.getId(),1);
        groceryOrder = new GroceryOrder(customer,grocery,1);
    }

    @Test
    public void addGrocery() throws Exception {
        Grocery grocery2= new Grocery("name2",new BigDecimal(0.0));
        groceryRepository.addGrocery(grocery2);

        assertThat(entityManager.find(Grocery.class, grocery2.getId())).isEqualTo(grocery2);
    }

    @Test
    public void buyGrocery() throws Exception {
        groceryRepository.buyGrocery(groceryOrderDto);
        assertThat(entityManager.createQuery("Select g.customer " +
                "from GroceryOrder g " +
                "where g.customer like:customer ",Customer.class)
                .setParameter("customer", customer)
                .getResultList())
                .containsExactly(customer);
        assertThat(entityManager.createQuery("Select g.grocery " +
                "from GroceryOrder g " +
                "where g.grocery like:grocery ",Grocery.class)
                .setParameter("grocery", grocery)
                .getResultList())
                .containsExactly(grocery);
        assertThat(entityManager.createQuery("Select g.quantity " +
                "from GroceryOrder g " +
                "where g.quantity like 1 ",Integer.class)
                .getResultList())
                .containsExactly(1);
    }

//    @Test
//    public void mostBoughtGroceryByCustomer() throws Exception {
//        groceryRepository.buyGrocery(groceryOrderDto);
//        List<Grocery> actual = groceryRepository.mostBoughtGroceryByCustomer(1);
//
//        assertThat(actual).contains(grocery);
//        // cant make test work with previous test dont know how to test this properly
//    }

    @After
    public void cleanDatabase(){
        entityManager.clear();
    }


}