package ru.iantonov.bar.repository;

import org.springframework.data.repository.CrudRepository;
import ru.iantonov.bar.model.domain.DrinkType;

import java.util.List;
import java.util.Optional;

public interface DrinkTypeRepository extends CrudRepository<DrinkType, Long> {
    Optional<DrinkType> findById(long id);
    List<DrinkType> findAllByOrderByPowerDesc();
}
