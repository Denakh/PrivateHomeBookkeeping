package mainpackage.entities.foreigncurrencies;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForeignCurrenciesRepository extends JpaRepository<ForeignCurrencies, Long> {

}
