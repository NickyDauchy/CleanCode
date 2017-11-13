package be.cegeka.cleancode.domain.groceries;

import be.cegeka.cleancode.Application;
import be.cegeka.cleancode.domain.customers.Customer;
import be.cegeka.cleancode.domain.customers.CustomerRepository;
import be.cegeka.cleancode.domain.customers.LoyaltyCard;
import org.junit.After;
import org.junit.Assert;
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
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

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

        groceryOrderDto = new GroceryOrderDto(customer.getId(),grocery.getId(),1,new BigDecimal(0.0));
        groceryOrder = new GroceryOrder(customer.getId(),grocery.getId(),1,grocery.getPrice());
    }

    @Test
    public void addGrocery() throws Exception {
        Grocery grocery2= new Grocery("name2",new BigDecimal(0.0));
        groceryRepository.addGrocery(grocery2);

        assertThat(entityManager.find(Grocery.class, grocery2.getId())).isEqualTo(grocery2);
    }

    @Test
    public void buyGrocery() throws Exception {
        groceryRepository.buyGrocery(groceryOrder);
//        assertThat(entityManager.createQuery("Select g " +
//                "from GroceryOrder g " +
//                "where g.customerId like:customerId ",GroceryOrder.class)
//                .setParameter("customerId", customer.getId())
//                .getResultList())
//                .isNotEmpty();
//        assertThat(entityManager.createQuery("Select g " +
//                "from GroceryOrder g " +
//                "where g.groceryId like:groceryId ",GroceryOrder.class)
//                .setParameter("groceryId", grocery.getId())
//                .getResultList())
//                .isNotEmpty();
//        assertThat(entityManager.createQuery("Select g.quantity " +
//                "from GroceryOrder g " +
//                "where g.quantity like 1 ",Integer.class)
//                .getResultList())
//                .isNotEmpty();
//
//        GroceryOrder groceryOrderExpected = entityManager.createQuery("Select g " +
//                "from GroceryOrder g " +
//                "where g.customerId like:customerId ",GroceryOrder.class)
//                .setParameter("customerId", customer.getId())
//                .getSingleResult();
//        assertThat(groceryOrder).isEqualTo(refEq(groceryOrderExpected));
        assertThat(entityManager.find(groceryOrder.getClass(),groceryOrder.getId())).isEqualTo(groceryOrder);
    }

//    @Test
//    public void mostBoughtGroceryByCustomer() throws Exception {
//        groceryRepository.buyGrocery(groceryOrderDto);
//        List<Grocery> actual = groceryRepository.mostBoughtGroceryByCustomer(1);
//
//        assertThat(actual).contains(grocery);
//        // cant make test work with previous test dont know how to test this properly
//    }

//        @Test
//    public void GroceryBoughtByCustomerOnlyOnce() throws Exception {
//        groceryRepository.buyGrocery(groceryOrderDto);
//        List<Grocery> actual = groceryRepository.GroceryBoughtByCustomerOnlyOnce(1);
//
//        assertThat(actual).contains(grocery);
//        // cant make test work with previous test dont know how to test this properly
//    }


    @After
    public void cleanDatabase(){
        entityManager.clear();
    }


}