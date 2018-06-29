package mainpackage.entities.balancestatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BallanceStatisticsServiceImpl implements BallanceStatisticsService {
    @Autowired
    private BallanceStatisticsRepository ballanceStatisticsRepository;

    @Override
    @Transactional
    public void addCharity(BallanceStatistics ballanceStatistics) {
        ballanceStatisticsRepository.save(ballanceStatistics);
    }

    @Override
    @Transactional
    public void updateCharity(BallanceStatistics ballanceStatistics) {
        ballanceStatisticsRepository.save(ballanceStatistics);
    }

    @Override
    @Transactional
    public void deleteCharity(Long id) {
        ballanceStatisticsRepository.delete(id);
    }

}
