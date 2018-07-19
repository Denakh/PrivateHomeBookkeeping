package mainpackage.entities.reserve;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    @Query("SELECT r FROM Reserve r WHERE r.user = :user ORDER BY r.id ASC")
    List<Reserve> getAllEntriesList(@Param("user") CustomUser user);

    @Query("SELECT r FROM Reserve r WHERE r.date >= :date AND r.user = :user ORDER BY r.id ASC")
    List<Reserve> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

    @Query("SELECT r FROM Reserve r WHERE r.id = (SELECT MAX(r.id) FROM AllocationOfProfits r WHERE r.user = :user)")
    Reserve findLastEntry(@Param("user") CustomUser user);

}
