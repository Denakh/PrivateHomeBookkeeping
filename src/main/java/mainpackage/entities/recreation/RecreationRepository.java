package mainpackage.entities.recreation;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecreationRepository extends JpaRepository<Recreation, Long> {

    @Query("SELECT r FROM Recreation r where r.id = (SELECT MAX(r.id) FROM Recreation r)")
    Recreation findLastEntry();

}
