package io.ewizyta.service;

import io.ewizyta.model.Grupa;
import io.ewizyta.model.User;
import io.ewizyta.repository.UserRepository;
import io.ewizyta.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImplement implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public UserServiceImplement(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getImie()
                    ,userRegistrationDto.getNazwisko()
                    ,userRegistrationDto.getEmail()
                    ,passwordEncoder.encode(userRegistrationDto.getHaslo())
                    ,userRegistrationDto.getPesel()
                    ,userRegistrationDto.getTelefon(),
                Grupa.KLIENT
        );
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username); //username = email
        if(user == null){ //nie znaleziono w bazie takiego uzytkownika
            throw new UsernameNotFoundException("Invalid emial or password.");
        }

        //tworzymy userObject SPRING SECURITY
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getHaslo(), Collections.singleton(mapGrupaToAuthorities(user.getTyp())));
    }

    private SimpleGrantedAuthority mapGrupaToAuthorities(Grupa grupa) {
         return new SimpleGrantedAuthority(grupa.name());
    }

}
