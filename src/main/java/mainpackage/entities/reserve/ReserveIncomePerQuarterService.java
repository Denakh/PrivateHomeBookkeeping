package mainpackage.entities.reserve;

import mainpackage.entities.charity.Charity;

public interface ReserveIncomePerQuarterService {

    void addReserveIncomePerQuarter(ReserveIncomePerQuarter reserveIncomePerQuarter);

    void updateReserveIncomePerQuarter(ReserveIncomePerQuarter reserveIncomePerQuarter);

    void deleteReserveIncomePerQuarter(Long id);

}
