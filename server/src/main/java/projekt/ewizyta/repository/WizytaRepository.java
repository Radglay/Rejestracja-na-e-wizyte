package projekt.ewizyta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projekt.ewizyta.model.Wizyta;

import java.util.List;

public interface WizytaRepository extends JpaRepository<Wizyta, Long> {

    public List<Wizyta> findAll();

    @Query("SELECT w FROM Wizyta w WHERE w.user_data.id = :id")
    public List<Wizyta> findByUserId(@Param("id") Long id);

    @Query("SELECT w FROM Wizyta w WHERE w.doctor_data.id = :id")
    public List<Wizyta> findByDoctorId(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM Wizyta w WHERE w.id = :id")
    public void deleteById(@Param("id") Long id);

    public Wizyta findWizytaById(Long id);
}
