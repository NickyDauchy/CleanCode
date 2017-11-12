package be.cegeka.cleancode.domain.groceries;

public class GroceryOrderDto {
    private int customerId;
    private int groceryId;
    private int quantity;

    public GroceryOrderDto() {
    }

    public GroceryOrderDto(int customerId, int groceryId, int quantity) {
        this.customerId = customerId;
        this.groceryId = groceryId;
        this.quantity = quantity;
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
}
