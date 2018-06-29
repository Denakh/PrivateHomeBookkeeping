package mainpackage.entities.currentexpensesrate;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CurrentExpensesRateRepository extends JpaRepository<CurrentExpensesRate, Long> {

    @Query("SELECT c FROM CurrentExpensesRate c where c.id = (SELECT MAX(c.id) FROM CurrentExpensesRate c)")
    CurrentExpensesRate findLastEntry();

}
