package mainpackage.entities.health;

public interface HealthService {

    void addHealth(Health health);

    void updateHealth(Health health);

    void deleteHealth(Long id);

    Health findLastEntry();

}
