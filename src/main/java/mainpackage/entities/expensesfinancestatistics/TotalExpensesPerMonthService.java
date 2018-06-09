package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.charity.Charity;

public interface TotalExpensesPerMonthService {

    void addTotalExpensesPerMonth(TotalExpensesPerMonth totalExpensesPerMonth);

    void updateTotalExpensesPerMonth(TotalExpensesPerMonth totalExpensesPerMonth);

    void deleteTotalExpensesPerMonth(Long id);

}
