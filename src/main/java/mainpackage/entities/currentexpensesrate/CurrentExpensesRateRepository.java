package mainpackage.entities.currentexpensesrate;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CurrentExpensesRateRepository extends JpaRepository<CurrentExpensesRate, Long> {

    @Query("SELECT c FROM CurrentExpensesRate c WHERE c.id = (SELECT MAX(c.id) FROM CurrentExpensesRate c WHERE c.user = :user)")
    CurrentExpensesRate findLastEntry(@Param("user") CustomUser user);

}
