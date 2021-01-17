package projekt.ewizyta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projekt.ewizyta.model.Doctor;
import projekt.ewizyta.model.User;
import projekt.ewizyta.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();

        if(tempEmail != null && !"".equals(tempEmail)) {
            User userObj = userService.fetchUserByEmail(tempEmail);

            if(userObj != null) { //jest juz taki uzytkownik w bazie
                throw new Exception("User with this email already exist");
            }
        }

        User userObj = null;
        userObj = userService.saveUser(user);

        return userObj;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User userObj = null;

        if(tempPassword != null && tempEmail != null) {
            userObj = userService.fetchUserByEmailAndPassword(tempEmail, tempPassword);
        }

        if(userObj == null) {
            throw new Exception("User does not exist, bad credentials");
        }
        return userObj;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/doctors")
    public List<Doctor> getAllDoctors() {
        System.out.println(userService.getAllDoctors().get(0).getType());
        return userService.getAllDoctors();
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/user")
    public User getUserData(@RequestBody User user) throws Exception {
        User userObj = null;

        if(user.getId() != 0 && user.getId() != null) {
            userObj = userService.fetchUserById(user.getId());
        }

        if(userObj == null) {
            throw new Exception("Nie ma takiego usera!");
        }

        return userObj;
    }
}

