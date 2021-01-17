package projekt.ewizyta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projekt.ewizyta.model.Doctor;
import projekt.ewizyta.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

    public User findByEmailAndPassword(String email, String password);


    //znajdz usera
    @Query("SELECT u FROM User u WHERE u.id = :id")
    public User findUserById(@Param("id") Long id);


    //znajdz dotora
    @Query("SELECT d FROM Doctor d WHERE d.id = :id")
    public Doctor findDoctorById(@Param("id") Long id);

    @Query("SELECT d FROM Doctor d")
    public List<Doctor> findAllDoctors();


}

