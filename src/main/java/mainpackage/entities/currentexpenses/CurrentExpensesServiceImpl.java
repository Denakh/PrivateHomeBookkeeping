package mainpackage.entities.currentexpenses;

import mainpackage.entities.charity.Charity;
import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    @Override
    public List<CurrentExpenses> findEntriesFromDate(CustomUser user, Date date) {
        return currentExpensesRepository.findEntriesFromDate(user, date);
    }

    public CurrentExpenses findLastEntry(CustomUser user) {
        return currentExpensesRepository.findLastEntry(user);
    }

}
