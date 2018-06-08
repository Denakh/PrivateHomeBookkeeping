package mainpackage.entities.currentexpenses;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;

public interface CurrentExpensesService {

    void addCurrentExpenses(CurrentExpenses currentExpenses);

    void updateCurrentExpenses(CurrentExpenses currentExpenses);

    void deleteCurrentExpenses(Long id);

}
