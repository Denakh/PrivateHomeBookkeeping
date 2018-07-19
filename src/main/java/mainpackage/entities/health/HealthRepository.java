package mainpackage.entities.health;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface HealthRepository extends JpaRepository<Health, Long> {

    @Query("SELECT h FROM Health h WHERE h.user = :user ORDER BY h.id ASC")
    List<Health> getAllEntriesList(@Param("user") CustomUser user);

    @Query("SELECT h FROM Health h WHERE h.date >= :date AND h.user = :user ORDER BY h.id ASC")
    List<Health> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

    @Query("SELECT h FROM Health h WHERE h.id = (SELECT MAX(h.id) FROM Health h WHERE h.user = :user)")
    Health findLastEntry(@Param("user") CustomUser user);

}
