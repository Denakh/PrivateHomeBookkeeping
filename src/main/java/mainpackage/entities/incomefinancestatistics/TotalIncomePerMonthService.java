package mainpackage.entities.incomefinancestatistics;

import mainpackage.entities.charity.Charity;

public interface TotalIncomePerMonthService {

    void addTotalIncomePerMonth(TotalIncomePerMonth totalIncomePerMonth);

    void updateTotalIncomePerMonth(TotalIncomePerMonth totalIncomePerMonth);

    void deleteTotalIncomePerMonth(Long id);

}
