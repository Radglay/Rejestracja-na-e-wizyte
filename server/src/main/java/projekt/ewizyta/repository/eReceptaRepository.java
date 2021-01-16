package projekt.ewizyta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projekt.ewizyta.model.*;

import java.util.List;

public interface eReceptaRepository extends JpaRepository<eRecepta, Long> {
        @Query("SELECT s FROM eRecepta s WHERE s.user_data.email=:email")
        public List<eRecepta> findByUserEmail(@Param("email") String email);

        @Query("SELECT l FROM Lek l WHERE l.nazwa=:nazwa")
        public Lek findByNazwa(@Param("nazwa") String nazwa);

}


