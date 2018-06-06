package mainpackage.entities.charity;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;

public interface CharityIncomePerQuarterService {

    void addCharityIncomePerQuarter(CharityIncomePerQuarter charityIncomePerQuarter);

    void updateCharityIncomePerQuarter(CharityIncomePerQuarter charityIncomePerQuarter);

    void deleteCharityIncomePerQuarter(Long id);

}
