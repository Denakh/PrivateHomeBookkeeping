package mainpackage.entities.deferrals;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DeferralsRepository extends JpaRepository<Deferrals, Long> {

    @Query("SELECT d FROM Deferrals d WHERE d.date >= :date AND d.user = :user ORDER BY d.id ASC")
    List<Deferrals> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

}
