package mainpackage.entities.allocationofprofits;

import mainpackage.entities.income.GeneralIncome;
import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AllocationOfProfitsRepository extends JpaRepository<AllocationOfProfits, Long> {

    @Query("SELECT a FROM AllocationOfProfits a where a.id = (SELECT MAX(a.id) FROM AllocationOfProfits a WHERE a.user = :user)")
    AllocationOfProfits findLastEntry(@Param("user") CustomUser user);

}
