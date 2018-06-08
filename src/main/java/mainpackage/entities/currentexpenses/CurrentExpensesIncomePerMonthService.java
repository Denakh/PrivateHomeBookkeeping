package mainpackage.entities.currentexpenses;

import mainpackage.entities.charity.Charity;

public interface CurrentExpensesIncomePerMonthService {

    void addCurrentExpensesIncomePerMonth(CurrentExpensesIncomePerMonth currentExpensesIncomePerMonth);

    void updateCurrentExpensesIncomePerMonth(CurrentExpensesIncomePerMonth currentExpensesIncomePerMonth);

    void deleteCurrentExpensesIncomePerMonth(Long id);

}
