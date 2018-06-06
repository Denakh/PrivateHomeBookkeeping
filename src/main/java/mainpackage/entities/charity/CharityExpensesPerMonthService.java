package mainpackage.entities.charity;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;

public interface CharityExpensesPerMonthService {

    void addCharityExpensesPerMonth(CharityExpensesPerMonth charityExpensesPerMonth);

    void updateCharityExpensesPerMonth(CharityExpensesPerMonth charityExpensesPerMonth);

    void deleteCharityExpensesPerMonth(Long id);

}
