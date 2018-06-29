package mainpackage.entities.currentexpensesrate;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurrentExpensesRateServiceImpl implements CurrentExpensesRateService {
    @Autowired
    private CurrentExpensesRateRepository currentExpensesRateRepository;

    @Override
    @Transactional
    public void addCurrentExpensesRate(CurrentExpensesRate currentExpensesRate) {
        currentExpensesRateRepository.save(currentExpensesRate);
    }

    @Override
    @Transactional
    public void updateCurrentExpensesRate(CurrentExpensesRate currentExpensesRate) {
        currentExpensesRateRepository.save(currentExpensesRate);
    }

    @Override
    @Transactional
    public void deleteCurrentExpensesRate(Long id) {
        currentExpensesRateRepository.delete(id);
    }

    @Override
    @Transactional
    public CurrentExpensesRate findLastEntry() {
        return currentExpensesRateRepository.findLastEntry();
    }

}
