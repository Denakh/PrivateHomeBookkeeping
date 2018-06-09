package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TotalExpensesPerQuarterRepository extends JpaRepository<TotalExpensesPerQuarter, Long> {

}
