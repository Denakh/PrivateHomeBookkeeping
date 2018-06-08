package mainpackage.entities.currentexpenses;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentExpensesIncomePerMonthRepository extends JpaRepository<CurrentExpensesIncomePerMonth, Long> {

}
