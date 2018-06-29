package mainpackage.entities.kidsandpets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KidsAndPetsExpensesPerQuarterServiceImpl implements KidsAndPetsExpensesPerQuarterService {
    @Autowired
    private KidsAndPetsExpensesPerQuarterRepository kidsAndPetsExpensesPerQuarterRepository;

    @Override
    @Transactional
    public void addKidsAndPetsExpensesPerQuarter(KidsAndPetsExpensesPerQuarter kidsAndPetsExpensesPerQuarter) {
        kidsAndPetsExpensesPerQuarterRepository.save(kidsAndPetsExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void updateKidsAndPetsExpensesPerQuarter(KidsAndPetsExpensesPerQuarter kidsAndPetsExpensesPerQuarter) {
        kidsAndPetsExpensesPerQuarterRepository.save(kidsAndPetsExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void deleteKidsAndPetsExpensesPerQuarter(Long id) {
        kidsAndPetsExpensesPerQuarterRepository.delete(id);
    }

}
