package be.cegeka.cleancode.application;

import be.cegeka.cleancode.domain.groceries.Grocery;
import be.cegeka.cleancode.domain.groceries.GroceryOrder;
import be.cegeka.cleancode.domain.groceries.GroceryOrderDto;
import be.cegeka.cleancode.domain.groceries.GroceryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.awt.*;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/grocery")
@Transactional
public class GroceryController {
    @Inject
    private GroceryService groceryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Grocery addGrocery(@RequestBody Grocery grocery) {
        return groceryService.addGrocery(grocery);

    }

    @PostMapping(path = "/buy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroceryOrder buyGrocery(@RequestBody GroceryOrderDto groceryOrderDto) {
        return groceryService.buyGrocery(groceryOrderDto);

    }

    @GetMapping(path = "/whichGroceryItemThisCustomerBoughtMost")
    public List<Grocery> mostBoughtGroceryByCustomer(@RequestParam(value = "customerId", required = true) int customerId) {
        return groceryService.mostBoughtGroceryByCustomer(customerId);
    }


}
