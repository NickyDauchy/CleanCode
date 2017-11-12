package be.cegeka.cleancode.domain.groceries;

import be.cegeka.cleancode.domain.customers.Customer;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.*;

@Named
public class GroceryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Grocery addGrocery(Grocery grocery) {
        entityManager.persist(grocery);
        return grocery;
    }

    public GroceryOrder buyGrocery(GroceryOrderDto groceryOrderDto) {
        Customer customer = entityManager.find(Customer.class, groceryOrderDto.getCustomerId());
        Grocery grocery = entityManager.find(Grocery.class, groceryOrderDto.getGroceryId());
        GroceryOrder groceryOrder = new GroceryOrder(customer, grocery, groceryOrderDto.getQuantity());
        entityManager.persist(groceryOrder);
        return groceryOrder;
    }

    public List<Grocery> mostBoughtGroceryByCustomer(int customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        Object[] result = entityManager.createQuery("Select g.grocery,sum(g.quantity) as pointsum " +
                "from GroceryOrder g " +
                "where g.customer like:customer " +
                "group by g.grocery " +
                "order by pointsum desc", Object[].class)
                .setParameter("customer", customer)
                .setMaxResults(1)
                .getSingleResult();

        return Arrays.asList((Grocery) result[0]);
    }
}
