package mainpackage.entities.incomefinancestatistics;

import mainpackage.entities.charity.Charity;

public interface IncomeFinanceStatisticsService {

    void addIncomeFinanceStatistics(IncomeFinanceStatistics incomeFinanceStatistics);

    void updateIncomeFinanceStatistics(IncomeFinanceStatistics incomeFinanceStatistics);

    void deleteIncomeFinanceStatistics(Long id);

}
