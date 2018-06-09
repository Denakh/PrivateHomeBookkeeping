package mainpackage.entities.health;

import mainpackage.entities.charity.Charity;

public interface HealthIncomePerMonthService {

    void addHealthIncomePerMonth(HealthIncomePerMonth healthIncomePerMonth);

    void updateHealthIncomePerMonth(HealthIncomePerMonth healthIncomePerMonth);

    void deleteHealthIncomePerMonth(Long id);

}
