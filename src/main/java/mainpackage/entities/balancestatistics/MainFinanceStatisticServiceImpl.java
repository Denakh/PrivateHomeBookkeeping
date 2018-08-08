package mainpackage.entities.balancestatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MainFinanceStatisticServiceImpl implements MainFinanceStatisticService {
    @Autowired
    private MainFinanceStatisticRepository mainFinanceStatisticRepository;

    @Override
    @Transactional
    public void addCharity(MainFinanceStatistic mainFinanceStatistic) {
        mainFinanceStatisticRepository.save(mainFinanceStatistic);
    }

    @Override
    @Transactional
    public void updateCharity(MainFinanceStatistic mainFinanceStatistic) {
        mainFinanceStatisticRepository.save(mainFinanceStatistic);
    }

    @Override
    @Transactional
    public void deleteCharity(Long id) {
        mainFinanceStatisticRepository.delete(id);
    }

}
