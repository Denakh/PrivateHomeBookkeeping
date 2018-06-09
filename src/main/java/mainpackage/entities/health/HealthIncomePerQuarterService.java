package mainpackage.entities.health;

import mainpackage.entities.charity.Charity;

public interface HealthIncomePerQuarterService {

    void addHealthIncomePerQuarter(HealthIncomePerQuarter healthIncomePerQuarter);

    void updateHealthIncomePerQuarter(HealthIncomePerQuarter healthIncomePerQuarter);

    void deleteHealthIncomePerQuarter(Long id);

}
