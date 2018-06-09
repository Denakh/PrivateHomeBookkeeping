package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.charity.Charity;

public interface ExpensesFinanceStatisticsService {

    void addExpensesFinanceStatistics(ExpensesFinanceStatistics expensesFinanceStatistics);

    void updateExpensesFinanceStatistics(ExpensesFinanceStatistics expensesFinanceStatistics);

    void deleteExpensesFinanceStatistics(Long id);

}
