package ru.iantonov.bar.repository;

import org.springframework.data.repository.CrudRepository;
import ru.iantonov.bar.model.domain.Drink;

import java.util.List;
import java.util.Optional;

public interface DrinkRepository extends CrudRepository<Drink, Long> {
    Optional<Drink> findById(long id);
    List<Drink> findAll();
}
