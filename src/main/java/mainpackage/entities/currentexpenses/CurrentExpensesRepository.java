package mainpackage.entities.currentexpenses;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentExpensesRepository extends JpaRepository<CurrentExpenses, Long> {

}
