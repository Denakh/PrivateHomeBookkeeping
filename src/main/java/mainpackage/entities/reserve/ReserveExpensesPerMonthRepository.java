package mainpackage.entities.reserve;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveExpensesPerMonthRepository extends JpaRepository<ReserveExpensesPerMonth, Long> {

}
