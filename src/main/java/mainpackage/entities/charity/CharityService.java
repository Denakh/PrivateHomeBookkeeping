package mainpackage.entities.charity;

import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface CharityService {

    void addCharity(Charity charity);

    void updateCharity(Charity charity);

    void deleteCharity(Long id);

    List<Charity> getAllEntriesList(CustomUser user);

    List<Charity> findEntriesFromDate(CustomUser user, Date date);

    Charity findLastEntry(CustomUser user);

}
