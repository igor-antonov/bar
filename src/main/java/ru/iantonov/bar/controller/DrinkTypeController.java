package ru.iantonov.bar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DrinkTypeController {

    @GetMapping("/drinktype")
    public String findAll(){
        return "/drinkType";
    }
}
