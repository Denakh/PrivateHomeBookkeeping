package mainpackage.entities.overallbalance;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OverallBalanceRepository extends JpaRepository<OverallBalance, Long> {

    @Query("SELECT o FROM OverallBalance o WHERE o.date >= :datefrom AND o.date < :dateto AND o.user = :user ORDER BY o.id ASC")
    List<OverallBalance> findEntriesBetweenDates(@Param("user") CustomUser user, @Param("datefrom") Date dateFrom,
                                                 @Param("dateto") Date dateTo);

    @Query("SELECT o FROM OverallBalance o WHERE o.id = (SELECT MAX(o.id) FROM OverallBalance o WHERE o.user = :user AND o.balanceType = :btype)")
    OverallBalance findLastEntry(@Param("user") CustomUser user, @Param("btype") BalanceType btype);

    @Query("SELECT o FROM OverallBalance o WHERE o.date >= :date AND o.user = :user ORDER BY o.id ASC")
    List<OverallBalance> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

}
