package mainpackage.entities.currentexpenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurrentExpensesServiceImpl implements CurrentExpensesService {
    @Autowired
    private CurrentExpensesRepository currentExpensesRepository;

    @Override
    @Transactional
    public void addCurrentExpenses(CurrentExpenses currentExpenses) {
        currentExpensesRepository.save(currentExpenses);
    }

    @Override
    @Transactional
    public void updateCurrentExpenses(CurrentExpenses currentExpenses) {
        currentExpensesRepository.save(currentExpenses);
    }

    @Override
    @Transactional
    public void deleteCurrentExpenses(Long id) {
        currentExpensesRepository.delete(id);
    }

}
