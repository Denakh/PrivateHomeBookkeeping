package mainpackage.entities.overallbalance;

import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OverallBalanceServiceImpl implements OverallBalanceService {
    @Autowired
    private OverallBalanceRepository overallBalanceRepository;

    @Override
    @Transactional
    public void addOverallBalance(OverallBalance overallBalance) {
        overallBalanceRepository.save(overallBalance);
    }

    @Override
    @Transactional
    public void updateOverallBalance(OverallBalance overallBalance) {
        overallBalanceRepository.save(overallBalance);
    }

    @Override
    @Transactional
    public void deleteOverallBalance(Long id) {
        overallBalanceRepository.delete(id);
    }

    @Override
    public List<OverallBalance> findEntriesBetweenDates(CustomUser user, Date dateFrom, Date dateTo) {
        return overallBalanceRepository.findEntriesBetweenDates(user, dateFrom, dateTo);
    }

    @Override
    public OverallBalance findLastEntry(CustomUser user, BalanceType btype) {
        return overallBalanceRepository.findLastEntry(user, btype);
    }

}
