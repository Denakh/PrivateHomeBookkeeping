package mainpackage.entities.health;

import mainpackage.entities.charity.Charity;

public interface HealthService {

    void addHealth(Health health);

    void updateHealth(Health health);

    void deleteHealth(Long id);

    Health findLastEntry();

}
