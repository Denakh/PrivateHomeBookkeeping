package mainpackage.entities.othercapitaloutlays;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OtherCapitalOutlaysExpensesPerQuarterServiceImpl implements OtherCapitalOutlaysExpensesPerQuarterService {
    @Autowired
    private OtherCapitalOutlaysExpensesPerQuarterRepository otherCapitalOutlaysExpensesPerQuarterRepository;

    @Override
    @Transactional
    public void addOtherCapitalOutlaysExpensesPerQuarter(OtherCapitalOutlaysExpensesPerQuarter otherCapitalOutlaysExpensesPerQuarter) {
        otherCapitalOutlaysExpensesPerQuarterRepository.save(otherCapitalOutlaysExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void updateOtherCapitalOutlaysExpensesPerQuarter(OtherCapitalOutlaysExpensesPerQuarter otherCapitalOutlaysExpensesPerQuarter) {
        otherCapitalOutlaysExpensesPerQuarterRepository.save(otherCapitalOutlaysExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void deleteOtherCapitalOutlaysExpensesPerQuarter(Long id) {
        otherCapitalOutlaysExpensesPerQuarterRepository.delete(id);
    }

}
