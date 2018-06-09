package mainpackage.entities.kidsandpets;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KidsAndPetsExpensesPerMonthServiceImpl implements KidsAndPetsExpensesPerMonthService {
    @Autowired
    private KidsAndPetsExpensesPerMonthRepository kidsAndPetsExpensesPerMonthRepository;

    @Override
    @Transactional
    public void addKidsAndPetsExpensesPerMonth(KidsAndPetsExpensesPerMonth kidsAndPetsExpensesPerMonth) {
        kidsAndPetsExpensesPerMonthRepository.save(kidsAndPetsExpensesPerMonth);
    }

    @Override
    @Transactional
    public void updateKidsAndPetsExpensesPerMonth(KidsAndPetsExpensesPerMonth kidsAndPetsExpensesPerMonth) {
        kidsAndPetsExpensesPerMonthRepository.save(kidsAndPetsExpensesPerMonth);
    }

    @Override
    @Transactional
    public void deleteKidsAndPetsExpensesPerMonth(Long id) {
        kidsAndPetsExpensesPerMonthRepository.delete(id);
    }

}
