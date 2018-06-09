package mainpackage.entities.reserve;

import mainpackage.entities.charity.Charity;

public interface ReserveExpensesPerMonthService {

    void addReserveExpensesPerMonth(ReserveExpensesPerMonth reserveExpensesPerMonth);

    void updateReserveExpensesPerMonth(ReserveExpensesPerMonth reserveExpensesPerMonth);

    void deleteReserveExpensesPerMonth(Long id);

}
