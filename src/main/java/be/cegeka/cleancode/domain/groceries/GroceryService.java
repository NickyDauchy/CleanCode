package be.cegeka.cleancode.domain.groceries;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GroceryService {
    @Inject
    private GroceryRepository groceryRepository;


    public Grocery addGrocery(Grocery grocery) {
        return groceryRepository.addGrocery(grocery);
    }

    public GroceryOrder buyGrocery(GroceryOrderDto groceryOrderDto) {

        return groceryRepository.buyGrocery(groceryOrderDto);
    }
}
