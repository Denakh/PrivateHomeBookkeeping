package mainpackage.entities.overallbalance;

import mainpackage.entities.charity.Charity;

public interface OverallBalanceService {

    void addOverallBalance(OverallBalance overallBalance);

    void updateOverallBalance(OverallBalance overallBalance);

    void deleteOverallBalance(Long id);

}
