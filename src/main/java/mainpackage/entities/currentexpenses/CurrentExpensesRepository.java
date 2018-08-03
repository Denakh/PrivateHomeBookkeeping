package mainpackage.entities.currentexpenses;

import mainpackage.entities.charity.Charity;
import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CurrentExpensesRepository extends JpaRepository<CurrentExpenses, Long> {

    @Query("SELECT c FROM CurrentExpenses c WHERE c.date >= :date AND c.user = :user ORDER BY c.id ASC")
    List<CurrentExpenses> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

    @Query("SELECT c FROM CurrentExpenses c WHERE c.id = (SELECT MAX(c.id) FROM CurrentExpenses c WHERE c.user = :user)")
    CurrentExpenses findLastEntry(@Param("user") CustomUser user);

}
