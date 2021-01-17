package projekt.ewizyta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projekt.ewizyta.model.Wizyta;

import javax.transaction.Transactional;
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

    @Transactional
    @Modifying
    @Query("UPDATE Wizyta w SET w.year = :year, w.month = :month, w.day = :day, w.hour = :hour, w.minute = :minute WHERE w.id = :id")
    public void updatById(@Param("id") Long id, @Param("year") int year, @Param("month") int month, @Param("day") int day, @Param("hour") int hour, @Param("minute") int minute);
}
