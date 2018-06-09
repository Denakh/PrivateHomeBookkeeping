package mainpackage.entities.deferrals;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeferralsRepository extends JpaRepository<Deferrals, Long> {

}
