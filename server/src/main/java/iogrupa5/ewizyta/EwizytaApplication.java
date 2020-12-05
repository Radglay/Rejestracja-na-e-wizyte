package iogrupa5.ewizyta;

import iogrupa5.ewizyta.model.User;
import iogrupa5.ewizyta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EwizytaApplication {

    public static void main(String[] args) {

        SpringApplication.run(EwizytaApplication.class, args);
    }



}
