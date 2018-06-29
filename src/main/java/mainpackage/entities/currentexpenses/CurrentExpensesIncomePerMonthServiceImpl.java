package mainpackage.entities.currentexpenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurrentExpensesIncomePerMonthServiceImpl implements CurrentExpensesIncomePerMonthService {
    @Autowired
    private CurrentExpensesIncomePerMonthRepository currentExpensesIncomePerMonthRepository;

    @Override
    @Transactional
    public void addCurrentExpensesIncomePerMonth(CurrentExpensesIncomePerMonth currentExpensesIncomePerMonth) {
        currentExpensesIncomePerMonthRepository.save(currentExpensesIncomePerMonth);
    }

    @Override
    @Transactional
    public void updateCurrentExpensesIncomePerMonth(CurrentExpensesIncomePerMonth currentExpensesIncomePerMonth) {
        currentExpensesIncomePerMonthRepository.save(currentExpensesIncomePerMonth);
    }

    @Override
    @Transactional
    public void deleteCurrentExpensesIncomePerMonth(Long id) {
        currentExpensesIncomePerMonthRepository.delete(id);
    }

}
