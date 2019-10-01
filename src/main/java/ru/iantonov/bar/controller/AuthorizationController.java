package ru.iantonov.bar.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.iantonov.bar.model.domain.User;
import ru.iantonov.bar.repository.UserRepository;

@Controller
public class AuthorizationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthorizationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/drink";
    }

    @GetMapping("/login")
    public String login(){
        return "loginPage";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String j_login, @RequestParam String fullName,
                               @RequestParam String j_password, @RequestParam String j_role){
        userRepository.save(
                new User(j_login, fullName, passwordEncoder.encode(j_password), j_role));
        return "loginPage";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registrationPage";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}