package mainpackage.entities.charity;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CharityRepository extends JpaRepository<Charity, Long> {

    @Query("SELECT c FROM Charity c WHERE c.user = :user ORDER BY c.id ASC")
    List<Charity> getAllEntriesList(@Param("user") CustomUser user);

    @Query("SELECT c FROM Charity c WHERE c.date >= :date AND c.user = :user ORDER BY c.id ASC")
    List<Charity> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

    @Query("SELECT c FROM Charity c WHERE c.id = (SELECT MAX(c.id) FROM Charity c WHERE c.user = :user)")
    Charity findLastEntry(@Param("user") CustomUser user);

}
