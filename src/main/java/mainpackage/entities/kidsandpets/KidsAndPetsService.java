package mainpackage.entities.kidsandpets;

import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface KidsAndPetsService {

    void addKidsAndPets(KidsAndPets kidsAndPets);

    void updateKidsAndPets(KidsAndPets kidsAndPets);

    void deleteKidsAndPets(Long id);

    List<KidsAndPets> getAllEntriesList(CustomUser user);

    List<KidsAndPets> findEntriesFromDate(CustomUser user, Date date);

    KidsAndPets findLastEntry(CustomUser user);

}
