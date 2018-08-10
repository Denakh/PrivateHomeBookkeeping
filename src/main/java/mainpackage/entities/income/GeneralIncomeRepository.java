package mainpackage.entities.income;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface GeneralIncomeRepository extends JpaRepository<GeneralIncome, Long> {

    @Query("SELECT g FROM GeneralIncome g where g.id = (SELECT MAX(g.id) FROM GeneralIncome g WHERE g.user = :user)")
    GeneralIncome findLastEntry(@Param("user") CustomUser user);

    @Query("SELECT i FROM GeneralIncome i WHERE i.date >= :date AND i.user = :user ORDER BY i.id ASC")
    List<GeneralIncome> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

}
