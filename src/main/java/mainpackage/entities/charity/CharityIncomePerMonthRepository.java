package mainpackage.entities.charity;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharityIncomePerMonthRepository extends JpaRepository<CharityIncomePerMonth, Long> {

}
