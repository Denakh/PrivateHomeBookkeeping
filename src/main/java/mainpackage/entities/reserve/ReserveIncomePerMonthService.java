package mainpackage.entities.reserve;

import mainpackage.entities.charity.Charity;

public interface ReserveIncomePerMonthService {

    void addReserveIncomePerMonth(ReserveIncomePerMonth reserveIncomePerMonth);

    void updateReserveIncomePerMonth(ReserveIncomePerMonth reserveIncomePerMonth);

    void deleteReserveIncomePerMonth(Long id);

}
