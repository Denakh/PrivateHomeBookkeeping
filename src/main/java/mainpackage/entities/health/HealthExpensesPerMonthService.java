package mainpackage.entities.health;

import mainpackage.entities.charity.Charity;

public interface HealthExpensesPerMonthService {

    void addHealthExpensesPerMonth(HealthExpensesPerMonth healthExpensesPerMonth);

    void updateHealthExpensesPerMonth(HealthExpensesPerMonth healthExpensesPerMonth);

    void deleteHealthExpensesPerMonth(Long id);

}
