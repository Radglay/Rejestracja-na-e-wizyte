package io.ewizyta.service;

import io.ewizyta.model.Grupa;
import io.ewizyta.model.User;
import io.ewizyta.repository.UserRepository;
import io.ewizyta.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService{

    @Autowired
    private UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getImie()
                    ,userRegistrationDto.getNazwisko()
                    ,userRegistrationDto.getEmail()
                    ,userRegistrationDto.getHaslo()
                    ,userRegistrationDto.getPesel()
                    ,userRegistrationDto.getTelefon(),
                Grupa.KLIENT
        );
        return userRepository.save(user);
    }


}
