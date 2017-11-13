package be.cegeka.cleancode.domain.groceries;

import be.cegeka.cleancode.domain.customers.Customer;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@Named
public class GroceryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Grocery addGrocery(Grocery grocery) {
        entityManager.persist(grocery);
        return grocery;
    }

    public GroceryOrder buyGrocery(GroceryOrder groceryOrder) {
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
//    public List<Grocery> GroceryBoughtByCustomerOnlyOnce(int customerId) {
//        Customer customer = entityManager.find(Customer.class, customerId);
//        Object[] result = entityManager.createQuery("Select g.grocery,sum(g.quantity) as pointsum " +
//                "from GroceryOrder g " +
//                "where g.customer like:customer and pointsum like 1 " +
//                "group by g.grocery "
//                , Object[].class)
//                .setParameter("customer", customer)
//                .setMaxResults(1)
//                .getSingleResult();
//
//        return Arrays.asList((Grocery) result[0]);
//    }
}
