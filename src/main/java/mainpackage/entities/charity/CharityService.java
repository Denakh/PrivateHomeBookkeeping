package mainpackage.entities.charity;

public interface CharityService {

    void addCharity(Charity charity);

    void updateCharity(Charity charity);

    void deleteCharity(Long id);
/*
    CustomUser getUserByLogin(String login);

    boolean existsByLogin(String login);
*/
}
