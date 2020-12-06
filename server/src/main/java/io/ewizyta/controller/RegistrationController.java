package io.ewizyta.controller;

import io.ewizyta.service.UserService;
import io.ewizyta.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    public RegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("USER")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("USER")UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
