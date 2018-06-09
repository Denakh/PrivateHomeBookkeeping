package mainpackage.entities.incomefinancestatistics;

import mainpackage.entities.charity.Charity;

public interface TotalIncomePerQuarterService {

    void addTotalIncomePerQuarter(TotalIncomePerQuarter totalIncomePerQuarter);

    void updateTotalIncomePerQuarter(TotalIncomePerQuarter totalIncomePerQuarter);

    void deleteTotalIncomePerQuarter(Long id);

}
