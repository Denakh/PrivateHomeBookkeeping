package mainpackage.entities.deferrals;

import mainpackage.entities.charity.Charity;

public interface CharityService {

    void addCharity(Charity charity);

    void updateCharity(Charity charity);

    void deleteCharity(Long id);
/*
    CustomUser getUserByLogin(String login);

    boolean existsByLogin(String login);
*/
}
