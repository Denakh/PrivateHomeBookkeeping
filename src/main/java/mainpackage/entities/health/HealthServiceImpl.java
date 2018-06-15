package mainpackage.entities.health;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HealthServiceImpl implements HealthService {
    @Autowired
    private HealthRepository healthRepository;

    @Override
    @Transactional
    public void addHealth(Health health) {
        healthRepository.save(health);
    }

    @Override
    @Transactional
    public void updateHealth(Health health) {
        healthRepository.save(health);
    }

    @Override
    @Transactional
    public void deleteHealth(Long id) {
        healthRepository.delete(id);
    }

    @Override
    @Transactional
    public Health findLastEntry() {
        return healthRepository.findLastEntry();
    }

}
