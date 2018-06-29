package mainpackage.entities.allocationofprofits;

import mainpackage.entities.income.GeneralIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AllocationOfProfitsRepository extends JpaRepository<AllocationOfProfits, Long> {

    @Query("SELECT a FROM AllocationOfProfits a where a.id = (SELECT MAX(a.id) FROM AllocationOfProfits a)")
    AllocationOfProfits findLastEntry();

}
