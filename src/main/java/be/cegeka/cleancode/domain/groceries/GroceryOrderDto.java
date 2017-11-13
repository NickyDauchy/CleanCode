package be.cegeka.cleancode.domain.groceries;

import java.math.BigDecimal;

public class GroceryOrderDto {
    public int customerId;
    public int groceryId;
    public int quantity;
    public BigDecimal unitprice;

    public GroceryOrderDto() {
    }

    public GroceryOrderDto(int customerId, int groceryId, int quantity,BigDecimal unitprice) {
        this.customerId = customerId;
        this.groceryId = groceryId;
        this.quantity = quantity;
        this.unitprice = unitprice;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getGroceryId() {
        return groceryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }
}
