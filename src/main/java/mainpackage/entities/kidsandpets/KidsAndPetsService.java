package mainpackage.entities.kidsandpets;

import mainpackage.entities.charity.Charity;

public interface KidsAndPetsService {

    void addKidsAndPets(KidsAndPets kidsAndPets);

    void updateKidsAndPets(KidsAndPets kidsAndPets);

    void deleteKidsAndPets(Long id);

    KidsAndPets findLastEntry();

}
