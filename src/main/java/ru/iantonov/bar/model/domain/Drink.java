package ru.iantonov.bar.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "drinks")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drink_id")
    private long id;
    @Column(name = "drink_name", nullable = false)
    private String name;
    private int amount;
    private int price;
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_type_id")
    private DrinkType drinkType;

    public Drink(String name, int amount, int price, DrinkType drinkType){
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.drinkType = drinkType;
        this.creationDate = LocalDate.now();
    }
}
