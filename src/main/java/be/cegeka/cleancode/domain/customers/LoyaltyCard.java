package be.cegeka.cleancode.domain.customers;

import javax.persistence.*;

@Entity
@Table(name="loyaltycards")
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

    public LoyaltyCard(String barcode) {
        this.barcode = barcode;
    }

    public int getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }
}
