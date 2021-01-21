package projekt.ewizyta.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;
import projekt.ewizyta.model.Doctor;
import projekt.ewizyta.model.Role;
import projekt.ewizyta.model.User;
import projekt.ewizyta.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void fetchUserByEmail() throws Exception{
        //istnieje
        User userTest = userService.fetchUserByEmail("example@gmail.com");
        Assert.notNull(userTest);

        //nie istnieje
        userTest = userService.fetchUserByEmail("niemaaaatakiego@test.pl");
        Assert.isNull(userTest);
    }

    @Test
    void fetchUserByEmailAndPassword() {
        User userTest = userService.fetchUserByEmailAndPassword("example@gmail.com", "zle haslo");
        Assert.isNull(userTest);

        userTest = userService.fetchUserByEmailAndPassword("nie ma maila @12312", "testowy123");
        Assert.isNull(userTest);

        userTest = userService.fetchUserByEmailAndPassword("example@gmail.com", "testowy123");
        Assert.notNull(userTest);
    }

    @Test
    void getAllDoctors() {
        List<Doctor> doktorzy = userService.getAllDoctors();

        for(Doctor d : doktorzy)
            System.out.println("specjalizacja: " + d.getType());

        Assert.notNull(doktorzy);
    }

    @Test
    void fetchDoctorById() {
        //Jest takie ID
        Doctor doctorTest = userService.fetchDoctorById(1L);
        Assert.notNull(doctorTest);


        //nie ma takiego ID
        doctorTest = userService.fetchDoctorById(10000000l);
        Assert.isNull(doctorTest);
    }
}