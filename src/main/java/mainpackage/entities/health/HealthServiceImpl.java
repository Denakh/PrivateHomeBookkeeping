package mainpackage.entities.health;

import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
    public List<Health> getAllEntriesList(CustomUser user) {
        return healthRepository.getAllEntriesList(user);
    }

    @Override
    public List<Health> findEntriesFromDate(CustomUser user, Date date) {
        return healthRepository.findEntriesFromDate(user, date);
    }

    @Override
    @Transactional
    public Health findLastEntry(CustomUser user) {
        return healthRepository.findLastEntry(user);
    }

}
