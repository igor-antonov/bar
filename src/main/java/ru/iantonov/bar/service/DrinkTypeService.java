package ru.iantonov.bar.service;

import org.springframework.stereotype.Service;
import ru.iantonov.bar.exception.DataNotFoundException;
import ru.iantonov.bar.model.domain.DrinkType;
import ru.iantonov.bar.repository.DrinkTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkTypeService {
    private final DrinkTypeRepository drinkTypeRepository;

    public DrinkTypeService(DrinkTypeRepository drinkTypeRepository) {
        this.drinkTypeRepository = drinkTypeRepository;
    }

    public List<DrinkType> findAll(){
        return drinkTypeRepository.findAllByOrderByPowerDesc();
    }

    public DrinkType findById(long id) throws DataNotFoundException {
        return drinkTypeRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }
}
