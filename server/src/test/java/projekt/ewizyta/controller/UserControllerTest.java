package projekt.ewizyta.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import projekt.ewizyta.model.User;
import projekt.ewizyta.service.UserService;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Test
    void registerUser() throws Exception {

//        MvcResult register = mockMvc.perform(post("/register").content("{\"email\": \"niemapowowdzenie23@wp.pl\", " +
//                "\"password\": \"testowe123\", " +
//                "\"name\": \"Andrzej\", " +
//                "\"surname\": \"Kowalski\", " +
//                "\"telephone\": \"123456789\", " +
//                "\"pesel\": \"11122233345\"}")
//                .contentType("application/json"))
//                .andDo(print())
//                .andExpect(status().is(200))
//                .andReturn();

        //taki jest, wywali błąd , exception
        MvcResult register2 = mockMvc.perform(post("/register").content("{\"email\": \"example@gmail.com\", " +
                "\"password\": \"testowy123\", " +
                "\"name\": \"Andrzej\", " +
                "\"surname\": \"Kowalski\", " +
                "\"telephone\": \"123456789\", " +
                "\"pesel\": \"11122233345\"}")
                .contentType("application/json"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    void loginUser() throws Exception{
        //wyrzuca błąd, nie ma takiego użytkownika jest to prawda!

//        MvcResult login = mockMvc.perform(post("/login").content("{\"email\": \"niema1234sss@gmail.com\", " +
//                "\"password\": \"haslo\"}")
//                .contentType("application/json"))
//                .andDo(print())
//                .andExpect(status().isUnauthorized())
//                .andReturn();


        //taki jest
        MvcResult login2 = mockMvc.perform(post("/login").content("{\"email\": \"exampaale@gmail.com\", " +
                "\"password\": \"testowy123\"}")
                .contentType("application/json"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();

        }
    }