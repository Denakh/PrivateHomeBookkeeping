package mainpackage.entities.othercapitaloutlays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OtherCapitalOutlaysExpensesPerMonthServiceImpl implements OtherCapitalOutlaysExpensesPerMonthService {
    @Autowired
    private OtherCapitalOutlaysExpensesPerMonthRepository otherCapitalOutlaysExpensesPerMonthRepository;

    @Override
    @Transactional
    public void addOtherCapitalOutlaysExpensesPerMonth(OtherCapitalOutlaysExpensesPerMonth otherCapitalOutlaysExpensesPerMonth) {
        otherCapitalOutlaysExpensesPerMonthRepository.save(otherCapitalOutlaysExpensesPerMonth);
    }

    @Override
    @Transactional
    public void updateOtherCapitalOutlaysExpensesPerMonth(OtherCapitalOutlaysExpensesPerMonth otherCapitalOutlaysExpensesPerMonth) {
        otherCapitalOutlaysExpensesPerMonthRepository.save(otherCapitalOutlaysExpensesPerMonth);
    }

    @Override
    @Transactional
    public void deleteOtherCapitalOutlaysExpensesPerMonth(Long id) {
        otherCapitalOutlaysExpensesPerMonthRepository.delete(id);
    }

}
