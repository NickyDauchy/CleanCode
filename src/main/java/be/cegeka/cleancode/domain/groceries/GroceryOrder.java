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

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "GROCERIES_ID")
    private Grocery grocery;

    private GroceryOrder() {
    }

    public GroceryOrder(Customer customer, Grocery grocery, int quantity) {
        this.customer = customer;
        this.grocery = grocery;
        this.quantity = quantity;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.date =  dtf.format(LocalDate.now());
        this.price = grocery.getPrice().multiply(new BigDecimal(quantity));
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

    public Customer getCustomer() {
        return customer;
    }

    public Grocery getGrocery() {
        return grocery;
    }
}
