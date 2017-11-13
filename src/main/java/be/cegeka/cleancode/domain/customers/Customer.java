package be.cegeka.cleancode.domain.customers;


import be.cegeka.cleancode.domain.groceries.GroceryOrder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "CARDID")
    private LoyaltyCard loyaltyCard;

    @OneToMany
    @JoinColumn(name = "CUSTOMER_ID")
    private List<GroceryOrder> groceryOrderList;


    private Customer() {
    }

    public String getName() {
        return name;
    }

    public LoyaltyCard getLoyaltyCard() {
        return loyaltyCard;
    }

    public Customer(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public void addLoyaltyCard(LoyaltyCard loyaltyCard) {
        this.loyaltyCard  = loyaltyCard;
    }

}
