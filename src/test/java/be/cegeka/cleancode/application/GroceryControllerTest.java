package be.cegeka.cleancode.application;


import be.cegeka.cleancode.domain.customers.Customer;
import be.cegeka.cleancode.domain.groceries.Grocery;
import be.cegeka.cleancode.domain.groceries.GroceryOrder;
import be.cegeka.cleancode.domain.groceries.GroceryService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class GroceryControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private GroceryController groceryController;

    @Mock
    private GroceryService groceryService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addGrocery() throws Exception {
        Grocery grocery = new Grocery("name",new BigDecimal(0.0));
        groceryController.addGrocery(grocery);
        verify(groceryService).addGrocery(grocery);

    }

    @Test
    public void buyGrocery() throws Exception {
        GroceryOrder groceryOrder = new GroceryOrder(new Customer("nicky"),new Grocery("grocery",new BigDecimal(2.2)),5);
        groceryController.buyGrocery(groceryOrder);
        verify(groceryService).buyGrocery(groceryOrder);
    }
}