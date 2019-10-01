package ru.iantonov.bar.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String login;
    @Column(name = "full_name")
    private String fullName;
    @Column(nullable = false)
    private String password;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    private int money;
    private int drunkenness;
    @Column(name = "user_role")
    private String role;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "favorite_drink_id")
    private Drink favoriteDrink;

    public User(String login, String fullName, String password, String role){
        this.login = login;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
        this.creationDate = LocalDate.now();
        this.money = 100;
        this.drunkenness = 0;
    }
}
