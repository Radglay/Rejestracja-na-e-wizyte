package projekt.ewizyta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projekt.ewizyta.model.Doctor;
import projekt.ewizyta.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

    public User findByEmailAndPassword(String email, String password);

    @Query("SELECT d FROM Doctor d")
    public List<Doctor> findAllDoctors();
}

