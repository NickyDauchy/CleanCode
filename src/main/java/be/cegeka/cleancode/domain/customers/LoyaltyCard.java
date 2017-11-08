package be.cegeka.cleancode.domain.customers;

import javax.persistence.*;

@Entity
public class LoyaltyCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "BARCODE")
    private String barcode;

    @Column(name = "BONUSPOINTS")
    private int bonuspoints;

    public LoyaltyCard() {
    }
}
