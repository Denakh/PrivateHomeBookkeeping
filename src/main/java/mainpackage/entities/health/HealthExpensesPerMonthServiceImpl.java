package mainpackage.entities.health;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HealthExpensesPerMonthServiceImpl implements HealthExpensesPerMonthService {
    @Autowired
    private HealthExpensesPerMonthRepository healthExpensesPerMonthRepository;

    @Override
    @Transactional
    public void addHealthExpensesPerMonth(HealthExpensesPerMonth healthExpensesPerMonth) {
        healthExpensesPerMonthRepository.save(healthExpensesPerMonth);
    }

    @Override
    @Transactional
    public void updateHealthExpensesPerMonth(HealthExpensesPerMonth healthExpensesPerMonth) {
        healthExpensesPerMonthRepository.save(healthExpensesPerMonth);
    }

    @Override
    @Transactional
    public void deleteHealthExpensesPerMonth(Long id) {
        healthExpensesPerMonthRepository.delete(id);
    }

}
