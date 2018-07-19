package mainpackage.entities.health;

import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface HealthService {

    void addHealth(Health health);

    void updateHealth(Health health);

    void deleteHealth(Long id);

    List<Health> getAllEntriesList(CustomUser user);

    List<Health> findEntriesFromDate(CustomUser user, Date date);

    Health findLastEntry(CustomUser user);

}
