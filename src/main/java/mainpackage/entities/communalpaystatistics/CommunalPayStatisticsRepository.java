package mainpackage.entities.communalpaystatistics;

import mainpackage.entities.currentexpenses.CurrentExpenses;
import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CommunalPayStatisticsRepository extends JpaRepository<CommunalPayStatistics, Long> {

    @Query("SELECT c FROM CommunalPayStatistics c WHERE c.date >= :date AND c.user = :user ORDER BY c.id ASC")
    List<CommunalPayStatistics> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

}
