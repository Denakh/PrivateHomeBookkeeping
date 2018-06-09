package mainpackage.entities.health;

import mainpackage.entities.charity.Charity;

public interface HealthExpensesPerQuarterService {

    void addHealthExpensesPerQuarter(HealthExpensesPerQuarter healthExpensesPerQuarter);

    void updateHealthExpensesPerQuarter(HealthExpensesPerQuarter healthExpensesPerQuarter);

    void deleteHealthExpensesPerQuarter(Long id);

}
