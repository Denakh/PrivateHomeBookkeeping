package mainpackage.entities.kidsandpets;

public interface KidsAndPetsService {

    void addKidsAndPets(KidsAndPets kidsAndPets);

    void updateKidsAndPets(KidsAndPets kidsAndPets);

    void deleteKidsAndPets(Long id);

    KidsAndPets findLastEntry();

}
