package projekt.ewizyta.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;
import projekt.ewizyta.model.User;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByEmail() {
        //nie istnieje
        User testUser = userRepository.findByEmail("nieistnieje@gmail.com"); //ACT
        Assert.isNull(testUser);

        //istnieje
        testUser = userRepository.findByEmail("example@gmail.com"); //ACT
        Assert.notNull(testUser);
    }

    @Test
    void findByEmailAndPassword() {
        //nie istnieje ani email ani hasło
        User testUser = userRepository.findByEmailAndPassword("nieistnieje@gmail.com", "tak"); //ACT
        Assert.isNull(testUser);

        //stnieje taki email, ale nie istnieje hasło
        testUser = userRepository.findByEmailAndPassword("example@gmail.com", "zlehaslo123");
        Assert.isNull(testUser);

        //nie istnieje taki email, ale istnieje haslo
        testUser = userRepository.findByEmailAndPassword("nieprawidlowy@wp.pl", "testowy123");
        Assert.isNull(testUser);

        //istnieje haslo i email
        testUser = userRepository.findByEmailAndPassword("example@gmail.com", "testowy123"); //ACT
        Assert.notNull(testUser);
    }
}