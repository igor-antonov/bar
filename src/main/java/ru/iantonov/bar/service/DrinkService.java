package ru.iantonov.bar.service;

import org.springframework.stereotype.Service;
import ru.iantonov.bar.model.domain.Drink;
import ru.iantonov.bar.repository.DrinkRepository;

import java.util.List;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public List<Drink> findAll(){
        return drinkRepository.findAll();
    }

    public Drink save(Drink drink){
        return drinkRepository.save(drink);
    }

    public void deleteById(long id){
        drinkRepository.deleteById(id);
    }
}
