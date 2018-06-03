package mainpackage.entities.communalpaystatistics;

import mainpackage.entities.charity.Charity;

public interface CommunalPayStatisticsService {

    void addCommunalPayStatistics(CommunalPayStatistics communalPayStatistics);

    void updateCommunalPayStatistics(CommunalPayStatistics communalPayStatistics);

    void deleteCommunalPayStatistics(Long id);
/*
    CustomUser getUserByLogin(String login);

    boolean existsByLogin(String login);
*/
}
