package mainpackage.entities.charity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CharityRepository extends JpaRepository<Charity, Long> {

    @Query("SELECT c FROM Charity c where c.id = (SELECT MAX(c.id) FROM Charity c)")
    Charity findLastEntry();

}
