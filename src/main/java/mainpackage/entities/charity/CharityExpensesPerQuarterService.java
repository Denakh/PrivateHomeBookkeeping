package mainpackage.entities.charity;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;

public interface CharityExpensesPerQuarterService {

    void addCharityExpensesPerQuarter(CharityExpensesPerQuarter charityExpensesPerQuarter);

    void updateCharityExpensesPerQuarter(CharityExpensesPerQuarter charityExpensesPerQuarter);

    void deleteCharityExpensesPerQuarter(Long id);

}
