package mainpackage.entities.charity;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CharityIncomePerQuarterServiceImpl implements CharityIncomePerQuarterService {
    @Autowired
    private CharityIncomePerQuarterRepository charityIncomePerQuarterRepository;

    @Override
    @Transactional
    public void addCharityIncomePerQuarter(CharityIncomePerQuarter charityIncomePerQuarter) {
        charityIncomePerQuarterRepository.save(charityIncomePerQuarter);
    }

    @Override
    @Transactional
    public void updateCharityIncomePerQuarter(CharityIncomePerQuarter charityIncomePerQuarter) {
        charityIncomePerQuarterRepository.save(charityIncomePerQuarter);
    }

    @Override
    @Transactional
    public void deleteCharityIncomePerQuarter(Long id) {
        charityIncomePerQuarterRepository.delete(id);
    }

}
