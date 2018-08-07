package mainpackage.entities.overallbalance;

import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface OverallBalanceService {

    void addOverallBalance(OverallBalance overallBalance);

    void updateOverallBalance(OverallBalance overallBalance);

    void deleteOverallBalance(Long id);

    List<OverallBalance> findEntriesBetweenDates(CustomUser user, Date dateFrom, Date dateTo);

    OverallBalance findLastEntry(CustomUser user, BalanceType btype);

}
