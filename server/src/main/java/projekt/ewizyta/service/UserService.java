package projekt.ewizyta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.ewizyta.model.Doctor;
import projekt.ewizyta.model.Role;
import projekt.ewizyta.model.User;
import projekt.ewizyta.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User fetchUserByEmail(String email) {
        return userRepository.findByEmail(email);  //find user by email
    }

    public User fetchUserByEmailAndPassword(String username, String password) {
        return userRepository.findByEmailAndPassword(username, password);
    }

    public List<Doctor> findAllDoctors() {
        return userRepository.findAllDoctors();
    }

    public User saveUser(User user) {
        User newUser = new User(user.getEmail(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getTelephone(),
                user.getPesel(),
                Arrays.asList(new Role("USER")));

        return userRepository.save(newUser);
    }
}

