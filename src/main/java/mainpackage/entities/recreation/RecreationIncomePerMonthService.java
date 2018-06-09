package mainpackage.entities.recreation;

import mainpackage.entities.charity.Charity;

public interface RecreationIncomePerMonthService {

    void addRecreationIncomePerMonth(RecreationIncomePerMonth recreationIncomePerMonth);

    void updateRecreationIncomePerMonth(RecreationIncomePerMonth recreationIncomePerMonth);

    void deleteRecreationIncomePerMonth(Long id);

}
