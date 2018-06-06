package mainpackage.entities.charity;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharityExpensesPerMonthRepository extends JpaRepository<CharityExpensesPerMonth, Long> {

}
