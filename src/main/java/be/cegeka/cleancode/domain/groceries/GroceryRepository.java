package be.cegeka.cleancode.domain.groceries;

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

    public GroceryOrder buyGrocery(GroceryOrder groceryOrder) {
        entityManager.persist(groceryOrder);
        return groceryOrder;
    }
}
