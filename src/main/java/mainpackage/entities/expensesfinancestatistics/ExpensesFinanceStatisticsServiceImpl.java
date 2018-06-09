package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExpensesFinanceStatisticsServiceImpl implements ExpensesFinanceStatisticsService {
    @Autowired
    private ExpensesFinanceStatisticsRepository expensesFinanceStatisticsRepository;

    @Override
    @Transactional
    public void addExpensesFinanceStatistics(ExpensesFinanceStatistics expensesFinanceStatistics) {
        expensesFinanceStatisticsRepository.save(expensesFinanceStatistics);
    }

    @Override
    @Transactional
    public void updateExpensesFinanceStatistics(ExpensesFinanceStatistics expensesFinanceStatistics) {
        expensesFinanceStatisticsRepository.save(expensesFinanceStatistics);
    }

    @Override
    @Transactional
    public void deleteExpensesFinanceStatistics(Long id) {
        expensesFinanceStatisticsRepository.delete(id);
    }

}
