package mainpackage.entities.foreigncurrencies;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ForeignCurrenciesRepository extends JpaRepository<ForeignCurrencies, Long> {

    @Query("SELECT f FROM ForeignCurrencies f WHERE f.user = :user ORDER BY f.id ASC")
    List<ForeignCurrencies> getAllEntriesList(@Param("user") CustomUser user);

}
