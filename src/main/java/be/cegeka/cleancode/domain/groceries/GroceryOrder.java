package be.cegeka.cleancode.domain.groceries;

import be.cegeka.cleancode.domain.customers.Customer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "GROCERIES_BOUGHT_BY_CUSTOMERS")
public class GroceryOrder {
    @Id
    @Column(name = "GBBC_ID ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "DATE")
    private String date;

//    @ManyToOne
    @Column(name = "CUSTOMER_ID")
    private int customerId;

//    @ManyToOne
    @Column(name = "GROCERIES_ID")
    private int groceryId;

    private GroceryOrder() {
    }

    public GroceryOrder(int customerId, int groceryId, int quantity, BigDecimal unitPrice) {
        this.customerId = customerId;
        this.groceryId = groceryId;
        this.quantity = quantity;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.date =  dtf.format(LocalDate.now());
        this.price = unitPrice.multiply(new BigDecimal(quantity));
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getGroceryId() {
        return groceryId;
    }
}
