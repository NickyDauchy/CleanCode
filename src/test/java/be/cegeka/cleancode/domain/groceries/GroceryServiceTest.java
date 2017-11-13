package be.cegeka.cleancode.domain.groceries;

import be.cegeka.cleancode.application.GroceryController;
import be.cegeka.cleancode.domain.customers.Customer;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

public class GroceryServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private GroceryService groceryService;

    @Mock
    private GroceryRepository groceryRepository;

    @Test
    public void addGrocery_shouldActivateGroceryRepository() throws Exception {
        Grocery grocery = new Grocery("name",new BigDecimal(0.0));
        groceryService.addGrocery(grocery);
        verify(groceryRepository).addGrocery(grocery);
    }

    @Test
    public void buyGrocery_shouldActivateGroceryRepository() throws Exception {
        GroceryOrderDto gOrderDto = new GroceryOrderDto(1,1,1,new BigDecimal(0.0));
        groceryService.buyGrocery(gOrderDto);
        verify(groceryRepository).buyGrocery(refEq(new GroceryOrder(gOrderDto.customerId,gOrderDto.groceryId,gOrderDto.quantity,gOrderDto.unitprice)));
    }

    @Test
    public void mostBoughtGroceryByCustomer_shouldActivateGroceryRepositry() throws Exception {
        groceryService.mostBoughtGroceryByCustomer(1);
        verify(groceryRepository).mostBoughtGroceryByCustomer(1);
    }
}