package mainpackage.entities.communalpaystatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommunalPayStatisticsServiceImpl implements CommunalPayStatisticsService {
    @Autowired
    private CommunalPayStatisticsRepository communalPayStatisticsRepository;

    @Override
    @Transactional
    public void addCommunalPayStatistics(CommunalPayStatistics communalPayStatistics) {
        communalPayStatisticsRepository.save(communalPayStatistics);
    }

    @Override
    @Transactional
    public void updateCommunalPayStatistics(CommunalPayStatistics communalPayStatistics) {
        communalPayStatisticsRepository.save(communalPayStatistics);
    }

    @Override
    @Transactional
    public void deleteCommunalPayStatistics(Long id) {
        communalPayStatisticsRepository.delete(id);
    }
/*
    @Override
    @Transactional(readOnly = true)
    public CustomUser getUserByLogin(String login) {
        return communalPayStatisticsRepository.findByLogin(login);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByLogin(String login) {
        return communalPayStatisticsRepository.existsByLogin(login);
    }
*/

}
