package mainpackage.entities.kidsandpets;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KidsAndPetsIncomePerMonthServiceImpl implements KidsAndPetsIncomePerMonthService {
    @Autowired
    private KidsAndPetsIncomePerMonthRepository kidsAndPetsIncomePerMonthRepository;

    @Override
    @Transactional
    public void addKidsAndPetsIncomePerMonth(KidsAndPetsIncomePerMonth kidsAndPetsIncomePerMonth) {
        kidsAndPetsIncomePerMonthRepository.save(kidsAndPetsIncomePerMonth);
    }

    @Override
    @Transactional
    public void updateKidsAndPetsIncomePerMonth(KidsAndPetsIncomePerMonth kidsAndPetsIncomePerMonth) {
        kidsAndPetsIncomePerMonthRepository.save(kidsAndPetsIncomePerMonth);
    }

    @Override
    @Transactional
    public void deleteKidsAndPetsIncomePerMonth(Long id) {
        kidsAndPetsIncomePerMonthRepository.delete(id);
    }

}
