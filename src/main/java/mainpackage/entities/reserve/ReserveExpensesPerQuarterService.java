package mainpackage.entities.reserve;

import mainpackage.entities.charity.Charity;

public interface ReserveExpensesPerQuarterService {

    void addReserveExpensesPerQuarter(ReserveExpensesPerQuarter reserveExpensesPerQuarter);

    void updateReserveExpensesPerQuarter(ReserveExpensesPerQuarter reserveExpensesPerQuarter);

    void deleteReserveExpensesPerQuarter(Long id);

}
