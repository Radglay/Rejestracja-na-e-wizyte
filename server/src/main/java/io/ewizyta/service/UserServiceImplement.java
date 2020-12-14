package io.ewizyta.service;

import io.ewizyta.model.Role;
import io.ewizyta.model.User;
import io.ewizyta.repository.UserRepository;
import io.ewizyta.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

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
                    ,userRegistrationDto.getPassword()
                    ,userRegistrationDto.getPesel()
                    ,userRegistrationDto.getTelefon()
                    ,Arrays.asList(new Role("USER"))
        );
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user  = userRepository.findUserByEmail(username); //username = email
        if(user == null){ //nie znaleziono w bazie takiego uzytkownika
            throw new UsernameNotFoundException("Invalid email or password.");
        }

        //tworzymy userObject SPRING SECURITY
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
