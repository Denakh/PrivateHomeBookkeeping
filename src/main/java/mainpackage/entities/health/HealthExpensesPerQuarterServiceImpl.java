package mainpackage.entities.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HealthExpensesPerQuarterServiceImpl implements HealthExpensesPerQuarterService {
    @Autowired
    private HealthExpensesPerQuarterRepository healthExpensesPerQuarterRepository;

    @Override
    @Transactional
    public void addHealthExpensesPerQuarter(HealthExpensesPerQuarter healthExpensesPerQuarter) {
        healthExpensesPerQuarterRepository.save(healthExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void updateHealthExpensesPerQuarter(HealthExpensesPerQuarter healthExpensesPerQuarter) {
        healthExpensesPerQuarterRepository.save(healthExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void deleteHealthExpensesPerQuarter(Long id) {
        healthExpensesPerQuarterRepository.delete(id);
    }

}
