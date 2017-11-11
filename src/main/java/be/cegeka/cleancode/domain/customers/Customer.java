package be.cegeka.cleancode.domain.customers;


import javax.persistence.*;

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
