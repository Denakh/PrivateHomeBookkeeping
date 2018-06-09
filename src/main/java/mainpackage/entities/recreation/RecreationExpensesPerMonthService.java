package mainpackage.entities.recreation;

import mainpackage.entities.charity.Charity;

public interface RecreationExpensesPerMonthService {

    void addRecreationExpensesPerMonth(RecreationExpensesPerMonth recreationExpensesPerMonth);

    void updateRecreationExpensesPerMonth(RecreationExpensesPerMonth recreationExpensesPerMonth);

    void deleteRecreationExpensesPerMonth(Long id);

}
