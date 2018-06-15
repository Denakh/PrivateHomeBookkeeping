package mainpackage.entities.kidsandpets;

import mainpackage.entities.charity.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KidsAndPetsRepository extends JpaRepository<KidsAndPets, Long> {

    @Query("SELECT k FROM KidsAndPets k where k.id = (SELECT MAX(k.id) FROM KidsAndPets k)")
    KidsAndPets findLastEntry();

}
