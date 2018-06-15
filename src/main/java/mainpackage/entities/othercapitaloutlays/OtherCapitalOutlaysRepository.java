package mainpackage.entities.othercapitaloutlays;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OtherCapitalOutlaysRepository extends JpaRepository<OtherCapitalOutlays, Long> {

    @Query("SELECT o FROM OtherCapitalOutlays o where o.id = (SELECT MAX(o.id) FROM OtherCapitalOutlays o)")
    OtherCapitalOutlays findLastEntry();

}
