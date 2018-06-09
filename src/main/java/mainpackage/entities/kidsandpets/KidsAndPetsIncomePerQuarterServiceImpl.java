package mainpackage.entities.kidsandpets;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KidsAndPetsIncomePerQuarterServiceImpl implements KidsAndPetsIncomePerQuarterService {
    @Autowired
    private KidsAndPetsIncomePerQuarterRepository kidsAndPetsIncomePerQuarterRepository;

    @Override
    @Transactional
    public void addKidsAndPetsIncomePerQuarter(KidsAndPetsIncomePerQuarter kidsAndPetsIncomePerQuarter) {
        kidsAndPetsIncomePerQuarterRepository.save(kidsAndPetsIncomePerQuarter);
    }

    @Override
    @Transactional
    public void updateKidsAndPetsIncomePerQuarter(KidsAndPetsIncomePerQuarter kidsAndPetsIncomePerQuarter) {
        kidsAndPetsIncomePerQuarterRepository.save(kidsAndPetsIncomePerQuarter);
    }

    @Override
    @Transactional
    public void deleteKidsAndPetsIncomePerQuarter(Long id) {
        kidsAndPetsIncomePerQuarterRepository.delete(id);
    }

}
