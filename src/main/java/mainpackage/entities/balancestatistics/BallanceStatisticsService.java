package mainpackage.entities.balancestatistics;

import mainpackage.entities.charity.Charity;

public interface BallanceStatisticsService {

    void addCharity(BallanceStatistics ballanceStatistics);

    void updateCharity(BallanceStatistics ballanceStatistics);

    void deleteCharity(Long id);

}
