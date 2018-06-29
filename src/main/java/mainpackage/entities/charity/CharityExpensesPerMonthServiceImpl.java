package mainpackage.entities.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CharityExpensesPerMonthServiceImpl implements CharityExpensesPerMonthService {
    @Autowired
    private CharityExpensesPerMonthRepository charityExpensesPerMonthRepository;

    @Override
    @Transactional
    public void addCharityExpensesPerMonth(CharityExpensesPerMonth charityExpensesPerMonth) {
        charityExpensesPerMonthRepository.save(charityExpensesPerMonth);
    }

    @Override
    @Transactional
    public void updateCharityExpensesPerMonth(CharityExpensesPerMonth charityExpensesPerMonth) {
        charityExpensesPerMonthRepository.save(charityExpensesPerMonth);
    }

    @Override
    @Transactional
    public void deleteCharityExpensesPerMonth(Long id) {
        charityExpensesPerMonthRepository.delete(id);
    }

}
