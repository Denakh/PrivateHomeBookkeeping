package mainpackage.entities.recreation;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RecreationRepository extends JpaRepository<Recreation, Long> {

    @Query("SELECT r FROM Recreation r WHERE r.user = :user ORDER BY r.id ASC")
    List<Recreation> getAllEntriesList(@Param("user") CustomUser user);

    @Query("SELECT r FROM Recreation r WHERE r.date >= :date AND r.user = :user ORDER BY r.id ASC")
    List<Recreation> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

    @Query("SELECT r FROM Recreation r WHERE r.id = (SELECT MAX(r.id) FROM AllocationOfProfits r WHERE r.user = :user)")
    Recreation findLastEntry(@Param("user") CustomUser user);

}
