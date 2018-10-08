package mainpackage.entities.communalpaystatistics;

import mainpackage.entities.currentexpenses.CurrentExpenses;
import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface CommunalPayStatisticsService {

    void addCommunalPayStatistics(CommunalPayStatistics communalPayStatistics);

    void updateCommunalPayStatistics(CommunalPayStatistics communalPayStatistics);

    void deleteCommunalPayStatistics(Long id);

    List<CommunalPayStatistics> findEntriesFromDate(CustomUser user, Date date);

}
