package projekt.ewizyta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projekt.ewizyta.model.Lek;

public interface LekRepository extends JpaRepository<Lek, Long> {

    @Query("SELECT l FROM Lek l WHERE l.nazwa = :nazwa")
    public Lek findByNazwa(@Param("nazwa") String nazwa);
}
