package mainpackage.entities.charity;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CharityExpensesPerQuarterServiceImpl implements CharityExpensesPerQuarterService {
    @Autowired
    private CharityExpensesPerQuarterRepository charityExpensesPerQuarterRepository;

    @Override
    @Transactional
    public void addCharityExpensesPerQuarter(CharityExpensesPerQuarter charityExpensesPerQuarter) {
        charityExpensesPerQuarterRepository.save(charityExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void updateCharityExpensesPerQuarter(CharityExpensesPerQuarter charityExpensesPerQuarter) {
        charityExpensesPerQuarterRepository.save(charityExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void deleteCharityExpensesPerQuarter(Long id) {
        charityExpensesPerQuarterRepository.delete(id);
    }

}
