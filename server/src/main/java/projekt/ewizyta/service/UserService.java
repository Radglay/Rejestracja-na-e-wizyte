package projekt.ewizyta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.ewizyta.model.Role;
import projekt.ewizyta.model.User;
import projekt.ewizyta.repository.UserRepository;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User fetchUserByEmail(String email) {
        return userRepository.findByEmail(email);  //find user by username
    }

    public User fetchUserByEmailAndPassword(String username, String password) {
        return userRepository.findByEmailAndPassword(username, password);
    }

    public User saveUser(User user) {
        User newUser = new User(user.getImie(),
                user.getNazwisko(),
                user.getEmail(),
                user.getPassword(),
                user.getPesel(),
                user.getTelefon(),
                Arrays.asList(new Role("USER")));

        return userRepository.save(newUser);
    }
}

