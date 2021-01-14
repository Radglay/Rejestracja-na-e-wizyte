package projekt.ewizyta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projekt.ewizyta.model.Lek;
import projekt.ewizyta.model.eSkierowanie;

import java.util.List;

public interface LekarstwaRepository extends JpaRepository<Lek, Long> {
    @Query("SELECT med FROM Lek med, Lekarstwa med_rec, eRecepta rec, User u WHERE u.email = :email" +
            " AND u.id = rec.user_data.id AND med_rec.eRecepta_id = rec.id AND med.id = med_rec.lek_id")
    public List<Lek> findByUserEmail(@Param("email") String email);
}
