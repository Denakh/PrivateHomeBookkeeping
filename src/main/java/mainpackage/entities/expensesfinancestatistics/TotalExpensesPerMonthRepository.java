package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TotalExpensesPerMonthRepository extends JpaRepository<TotalExpensesPerMonth, Long> {

}