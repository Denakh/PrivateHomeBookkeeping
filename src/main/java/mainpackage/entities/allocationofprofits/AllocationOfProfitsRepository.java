package mainpackage.entities.allocationofprofits;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AllocationOfProfitsRepository extends JpaRepository<AllocationOfProfits, Long> {

    @Query("SELECT a FROM AllocationOfProfits a WHERE a.id = (SELECT MAX(a.id) FROM AllocationOfProfits a WHERE a.user = :user)")
    AllocationOfProfits findLastEntry(@Param("user") CustomUser user);

    @Query("SELECT a FROM AllocationOfProfits a WHERE a.date >= :date AND a.user = :user ORDER BY a.id ASC")
    List<AllocationOfProfits> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

}
