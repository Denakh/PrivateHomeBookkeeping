package mainpackage.entities.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HealthIncomePerMonthServiceImpl implements HealthIncomePerMonthService {
    @Autowired
    private HealthIncomePerMonthRepository healthIncomePerMonthRepository;

    @Override
    @Transactional
    public void addHealthIncomePerMonth(HealthIncomePerMonth healthIncomePerMonth) {
        healthIncomePerMonthRepository.save(healthIncomePerMonth);
    }

    @Override
    @Transactional
    public void updateHealthIncomePerMonth(HealthIncomePerMonth healthIncomePerMonth) {
        healthIncomePerMonthRepository.save(healthIncomePerMonth);
    }

    @Override
    @Transactional
    public void deleteHealthIncomePerMonth(Long id) {
        healthIncomePerMonthRepository.delete(id);
    }

}
