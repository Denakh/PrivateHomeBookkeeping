package mainpackage.entities.communalpaystatistics;

public interface CommunalPayStatisticsService {

    void addCommunalPayStatistics(CommunalPayStatistics communalPayStatistics);

    void updateCommunalPayStatistics(CommunalPayStatistics communalPayStatistics);

    void deleteCommunalPayStatistics(Long id);
/*
    CustomUser getUserByLogin(String login);

    boolean existsByLogin(String login);
*/
}
