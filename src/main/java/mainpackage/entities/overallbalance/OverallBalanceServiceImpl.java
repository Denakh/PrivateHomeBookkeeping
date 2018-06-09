package mainpackage.entities.overallbalance;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
