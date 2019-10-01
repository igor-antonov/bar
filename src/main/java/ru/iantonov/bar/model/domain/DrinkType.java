package ru.iantonov.bar.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "drink_types")
public class DrinkType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drink_type_id", nullable = false)
    private long id;
    @Column(name = "drink_type_name", nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private int power;
}
