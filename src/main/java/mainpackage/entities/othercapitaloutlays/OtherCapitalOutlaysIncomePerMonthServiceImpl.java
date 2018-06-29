package mainpackage.entities.othercapitaloutlays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OtherCapitalOutlaysIncomePerMonthServiceImpl implements OtherCapitalOutlaysIncomePerMonthService {
    @Autowired
    private OtherCapitalOutlaysIncomePerMonthRepository otherCapitalOutlaysIncomePerMonthRepository;

    @Override
    @Transactional
    public void addOtherCapitalOutlaysIncomePerMonth(OtherCapitalOutlaysIncomePerMonth otherCapitalOutlaysIncomePerMonth) {
        otherCapitalOutlaysIncomePerMonthRepository.save(otherCapitalOutlaysIncomePerMonth);
    }

    @Override
    @Transactional
    public void updateOtherCapitalOutlaysIncomePerMonth(OtherCapitalOutlaysIncomePerMonth otherCapitalOutlaysIncomePerMonth) {
        otherCapitalOutlaysIncomePerMonthRepository.save(otherCapitalOutlaysIncomePerMonth);
    }

    @Override
    @Transactional
    public void deleteOtherCapitalOutlaysIncomePerMonth(Long id) {
        otherCapitalOutlaysIncomePerMonthRepository.delete(id);
    }

}
