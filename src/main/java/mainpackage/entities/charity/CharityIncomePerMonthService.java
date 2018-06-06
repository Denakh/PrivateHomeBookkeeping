package mainpackage.entities.charity;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;

public interface CharityIncomePerMonthService {

    void addCharityIncomePerMonth(CharityIncomePerMonth charityIncomePerMonth);

    void updateCharityIncomePerMonth(CharityIncomePerMonth charityIncomePerMonth);

    void deleteCharityIncomePerMonth(Long id);

}
