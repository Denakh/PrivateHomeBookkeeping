package mainpackage.entities.incomefinancestatistics;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncomeFinanceStatisticsServiceImpl implements IncomeFinanceStatisticsService {
    @Autowired
    private IncomeFinanceStatisticsRepository incomeFinanceStatisticsRepository;

    @Override
    @Transactional
    public void addIncomeFinanceStatistics(IncomeFinanceStatistics incomeFinanceStatistics) {
        incomeFinanceStatisticsRepository.save(incomeFinanceStatistics);
    }

    @Override
    @Transactional
    public void updateIncomeFinanceStatistics(IncomeFinanceStatistics incomeFinanceStatistics) {
        incomeFinanceStatisticsRepository.save(incomeFinanceStatistics);
    }

    @Override
    @Transactional
    public void deleteIncomeFinanceStatistics(Long id) {
        incomeFinanceStatisticsRepository.delete(id);
    }

}
