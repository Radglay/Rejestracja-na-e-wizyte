package projekt.ewizyta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projekt.ewizyta.model.eSkierowanie;

import java.util.List;


public interface eSkierowanieRepository extends JpaRepository<eSkierowanie, Integer> {
    @Query("SELECT s FROM eSkierowanie s WHERE s.user_data.email=:email")
    public List<eSkierowanie> findByUserEmail(@Param("email") String email);
}

