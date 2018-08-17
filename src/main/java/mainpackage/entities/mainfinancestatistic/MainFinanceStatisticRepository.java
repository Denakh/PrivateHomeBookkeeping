package mainpackage.entities.mainfinancestatistic;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MainFinanceStatisticRepository extends JpaRepository<MainFinanceStatistic, Long> {

    @Query("SELECT m FROM MainFinanceStatistic m WHERE m.user = :user ORDER BY m.id ASC")
    List<MainFinanceStatistic> findAllEntries(@Param("user") CustomUser user);

}
