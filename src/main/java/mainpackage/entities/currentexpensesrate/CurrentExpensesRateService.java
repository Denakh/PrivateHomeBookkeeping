package mainpackage.entities.currentexpensesrate;

import mainpackage.entities.charity.Charity;

public interface CurrentExpensesRateService {

    void addCurrentExpensesRate(CurrentExpensesRate currentExpensesRate);

    void updateCurrentExpensesRate(CurrentExpensesRate currentExpensesRate);

    void deleteCurrentExpensesRate(Long id);

}
