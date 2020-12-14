package io.ewizyta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ewizyta.repository.UserRepository;
import io.ewizyta.service.UserService;
import io.ewizyta.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserService userService;

    public RegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public String registerAccount(@RequestBody UserRegistrationDto registrationDto) throws JsonProcessingException {
        System.out.println(registrationDto.getUsername());
        System.out.println(registrationDto.getPassword());

        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
