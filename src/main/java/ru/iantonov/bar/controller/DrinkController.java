package ru.iantonov.bar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.iantonov.bar.exception.DataNotFoundException;
import ru.iantonov.bar.model.domain.Drink;
import ru.iantonov.bar.model.domain.DrinkType;
import ru.iantonov.bar.model.domain.UserDetailsAdapter;
import ru.iantonov.bar.service.DrinkService;
import ru.iantonov.bar.service.DrinkTypeService;

import java.util.Arrays;

@Controller
public class DrinkController {

    private final Logger log = LoggerFactory.getLogger(DrinkController.class);
    private final DrinkService drinkService;
    private final DrinkTypeService drinkTypeService;

    public DrinkController(DrinkService drinkService, DrinkTypeService drinkTypeService) {
        this.drinkService = drinkService;
        this.drinkTypeService = drinkTypeService;
    }

    @GetMapping("/drink")
    public String findAll(Model model, @AuthenticationPrincipal UserDetailsAdapter userDetails){
        model.addAttribute("drinks", drinkService.findAll());
        model.addAttribute("drink_types", drinkTypeService.findAll());
        log.info("name: " + userDetails.getUsername());
        log.info("role: " + userDetails.getAuthorities());
        return "drink";
    }

    @PostMapping("/drink")
    public String save(Model model, @RequestParam String name, @RequestParam int amount,
                       @RequestParam int price, @RequestParam(name = "drinkType") String drinkTypeId) {
        try{
            log.info("сохранение нового напитка: " + name);
            DrinkType drinkType = drinkTypeService.findById(Long.valueOf(drinkTypeId));
            Drink drink = new Drink(name, amount, price, drinkType);
            log.info(drink.toString());
            drinkService.save(drink);
            log.info("успешно");
            model.addAttribute("drinks", drinkService.findAll());
            return "redirect:/drink";
        }
        catch (Exception e){
            model.addAttribute("message", e.getMessage());
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
            return "error";
        }
    }

    //выпивать может только Юзер
    //go home -> full health
    //go work -> + 100 money
    //кнопка как всегда
}
