package mainpackage.entities.kidsandpets;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface KidsAndPetsRepository extends JpaRepository<KidsAndPets, Long> {

    @Query("SELECT k FROM KidsAndPets k WHERE k.user = :user ORDER BY k.id ASC")
    List<KidsAndPets> getAllEntriesList(@Param("user") CustomUser user);

    @Query("SELECT k FROM KidsAndPets k WHERE k.date >= :date AND k.user = :user ORDER BY k.id ASC")
    List<KidsAndPets> findEntriesFromDate(@Param("user") CustomUser user, @Param("date") Date date);

    @Query("SELECT k FROM KidsAndPets k WHERE k.id = (SELECT MAX(k.id) FROM KidsAndPets k WHERE k.user = :user)")
    KidsAndPets findLastEntry(@Param("user") CustomUser user);

}
