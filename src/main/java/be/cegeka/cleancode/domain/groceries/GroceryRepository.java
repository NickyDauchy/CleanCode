package be.cegeka.cleancode.domain.groceries;

import be.cegeka.cleancode.domain.customers.Customer;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        Grocery grocery = entityManager.find(Grocery.class,groceryOrderDto.getGroceryId());
        GroceryOrder groceryOrder = new GroceryOrder(customer,grocery,groceryOrderDto.getQuantity());
        entityManager.persist(groceryOrder);
        return groceryOrder;
    }
}
