package mainpackage.entities.income;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query("SELECT i FROM Income i WHERE i.date >= :date AND i.user = :user ORDER BY i.id ASC")
    List<Income> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

    @Query("SELECT i FROM Income i WHERE i.date > :datefrom AND i.date <= :dateto AND i.user = :user ORDER BY i.id ASC")
    List<Income> findEntriesBetweenDates(@Param("user") CustomUser user, @Param("datefrom") Date dateFrom,
                                         @Param("dateto") Date dateTo);

}
