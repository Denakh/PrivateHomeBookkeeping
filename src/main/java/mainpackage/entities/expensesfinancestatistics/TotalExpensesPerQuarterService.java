package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.charity.Charity;

public interface TotalExpensesPerQuarterService {

    void addTotalExpensesPerQuarter(TotalExpensesPerQuarter totalExpensesPerQuarter);

    void updateTotalExpensesPerQuarter(TotalExpensesPerQuarter totalExpensesPerQuarter);

    void deleteTotalExpensesPerQuarter(Long id);

}
