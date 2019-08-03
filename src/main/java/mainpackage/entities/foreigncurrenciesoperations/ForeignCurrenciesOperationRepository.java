package mainpackage.entities.foreigncurrenciesoperations;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ForeignCurrenciesOperationRepository extends JpaRepository<ForeignCurrenciesOperation, Long> {

    @Query("SELECT f FROM ForeignCurrenciesOperation f WHERE f.user = :user ORDER BY f.id ASC")
    List<ForeignCurrenciesOperation> getAllEntriesList(@Param("user") CustomUser user);

    @Query("SELECT f FROM ForeignCurrenciesOperation f WHERE f.date >= :date AND f.user = :user ORDER BY f.id ASC")
    List<ForeignCurrenciesOperation> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

}
