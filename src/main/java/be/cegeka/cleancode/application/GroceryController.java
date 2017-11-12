package be.cegeka.cleancode.application;

import be.cegeka.cleancode.domain.groceries.Grocery;
import be.cegeka.cleancode.domain.groceries.GroceryOrder;
import be.cegeka.cleancode.domain.groceries.GroceryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.transaction.Transactional;

@RestController
@RequestMapping(path = "/grocery")
@Transactional
public class GroceryController {
    @Inject
    private GroceryService groceryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Grocery addGrocery(@RequestBody Grocery grocery){
        return groceryService.addGrocery(grocery);

    }
    @PostMapping(path = "/buy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroceryOrder buyGrocery(@RequestBody GroceryOrder groceryOrder){
        return groceryService.buyGrocery(groceryOrder);

    }



}
