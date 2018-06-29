package mainpackage.entities.income;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GeneralIncomeRepository extends JpaRepository<GeneralIncome, Long> {

    @Query("SELECT g FROM GeneralIncome g where g.id = (SELECT MAX(g.id) FROM GeneralIncome g)")
    GeneralIncome findLastEntry();

}
