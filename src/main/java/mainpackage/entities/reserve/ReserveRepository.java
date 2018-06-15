package mainpackage.entities.reserve;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    @Query("SELECT r FROM Reserve r where r.id = (SELECT MAX(r.id) FROM Reserve r)")
    Reserve findLastEntry();

}
