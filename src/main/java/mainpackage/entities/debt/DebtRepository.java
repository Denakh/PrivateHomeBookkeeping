package mainpackage.entities.debt;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DebtRepository extends JpaRepository<Debt, Long> {

    @Query("SELECT d FROM Debt d where d.id = (SELECT MAX(d.id) FROM Debt d WHERE d.user = :user)")
    Debt findLastEntry(@Param("user") CustomUser user);

}
