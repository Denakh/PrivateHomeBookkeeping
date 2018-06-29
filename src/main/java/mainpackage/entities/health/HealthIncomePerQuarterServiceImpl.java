package mainpackage.entities.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HealthIncomePerQuarterServiceImpl implements HealthIncomePerQuarterService {
    @Autowired
    private HealthIncomePerQuarterRepository healthIncomePerQuarterRepository;

    @Override
    @Transactional
    public void addHealthIncomePerQuarter(HealthIncomePerQuarter healthIncomePerQuarter) {
        healthIncomePerQuarterRepository.save(healthIncomePerQuarter);
    }

    @Override
    @Transactional
    public void updateHealthIncomePerQuarter(HealthIncomePerQuarter healthIncomePerQuarter) {
        healthIncomePerQuarterRepository.save(healthIncomePerQuarter);
    }

    @Override
    @Transactional
    public void deleteHealthIncomePerQuarter(Long id) {
        healthIncomePerQuarterRepository.delete(id);
    }

}
