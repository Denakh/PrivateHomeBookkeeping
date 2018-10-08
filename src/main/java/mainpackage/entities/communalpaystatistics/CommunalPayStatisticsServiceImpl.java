package mainpackage.entities.communalpaystatistics;

import mainpackage.entities.currentexpenses.CurrentExpenses;
import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    @Override
    public List<CommunalPayStatistics> findEntriesFromDate(CustomUser user, Date date) {
        return communalPayStatisticsRepository.findEntriesFromDate(user, date);
    }


}
