package mainpackage.entities.debt;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DebtRepository extends JpaRepository<Debt, Long> {

    @Query("SELECT d FROM Debt d where d.id = (SELECT MAX(d.id) FROM Debt d WHERE d.user = :user)")
    Debt findLastEntry(@Param("user") CustomUser user);

    @Query("SELECT d FROM Debt d where d.user = :user AND d.id = :id")
    Debt findEntryById(@Param("user") CustomUser user, @Param("id") long id);

    @Query("SELECT d FROM Debt d WHERE d.idDebtForChange = 0 AND d.remainingSum > 0 AND d.user = :user ORDER BY d.id ASC")
    List<Debt> findEffectiveDebtsList(@Param("user") CustomUser user);

    @Query("SELECT d FROM Debt d WHERE d.date >= :date AND d.user = :user ORDER BY d.id ASC")
    List<Debt> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

}
