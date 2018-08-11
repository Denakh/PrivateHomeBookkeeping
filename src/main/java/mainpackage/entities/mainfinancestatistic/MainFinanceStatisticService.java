package mainpackage.entities.mainfinancestatistic;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MainFinanceStatisticService {

    void addMainFinanceStatistic(MainFinanceStatistic mainFinanceStatistic);

    void updateMainFinanceStatistic(MainFinanceStatistic mainFinanceStatistic);

    void deleteMainFinanceStatistic(Long id);

    List<MainFinanceStatistic> findAllEntries(CustomUser user);

}
