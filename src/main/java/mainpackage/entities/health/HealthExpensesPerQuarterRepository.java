package mainpackage.entities.health;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthExpensesPerQuarterRepository extends JpaRepository<HealthExpensesPerQuarter, Long> {

}
