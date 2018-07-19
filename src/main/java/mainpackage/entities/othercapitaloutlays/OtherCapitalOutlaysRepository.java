package mainpackage.entities.othercapitaloutlays;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OtherCapitalOutlaysRepository extends JpaRepository<OtherCapitalOutlays, Long> {

    @Query("SELECT o FROM OtherCapitalOutlays o WHERE o.user = :user ORDER BY o.id ASC")
    List<OtherCapitalOutlays> getAllEntriesList(@Param("user") CustomUser user);

    @Query("SELECT o FROM OtherCapitalOutlays o WHERE o.date >= :date AND o.user = :user ORDER BY o.id ASC")
    List<OtherCapitalOutlays> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

    @Query("SELECT o FROM OtherCapitalOutlays o WHERE o.id = (SELECT MAX(o.id) FROM OtherCapitalOutlays o WHERE o.user = :user)")
    OtherCapitalOutlays findLastEntry(@Param("user") CustomUser user);

}
