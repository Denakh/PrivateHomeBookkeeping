package mainpackage.entities.currentexpensesrate;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;

public interface CurrentExpensesRateService {

    void addCurrentExpensesRate(CurrentExpensesRate currentExpensesRate);

    void updateCurrentExpensesRate(CurrentExpensesRate currentExpensesRate);

    void deleteCurrentExpensesRate(Long id);

    CurrentExpensesRate findLastEntry();

}
