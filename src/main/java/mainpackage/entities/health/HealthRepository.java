package mainpackage.entities.health;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HealthRepository extends JpaRepository<Health, Long> {

    @Query("SELECT h FROM Health h where h.id = (SELECT MAX(h.id) FROM Health h)")
    Health findLastEntry();

}
