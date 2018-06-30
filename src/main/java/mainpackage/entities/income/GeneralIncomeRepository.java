package mainpackage.entities.income;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GeneralIncomeRepository extends JpaRepository<GeneralIncome, Long> {

    @Query("SELECT g FROM GeneralIncome g where g.id = (SELECT MAX(g.id) FROM GeneralIncome g WHERE g.user = :user)")
    GeneralIncome findLastEntry(@Param("user") CustomUser user);

}
