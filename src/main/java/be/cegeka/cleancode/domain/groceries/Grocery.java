package be.cegeka.cleancode.domain.groceries;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "GROCERIES")

public class Grocery {
    @Id
    @Column(name = "GROCERIES_ID ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAME")
    private String name;

    @Column(name = "SELLING_PRICE")
    private BigDecimal price;

    public Grocery(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    private Grocery() {
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
