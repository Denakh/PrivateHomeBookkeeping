package mainpackage.entities.debt;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtRepository extends JpaRepository<Debt, Long> {

}