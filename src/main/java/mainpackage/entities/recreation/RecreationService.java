package mainpackage.entities.recreation;

import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface RecreationService {

    void addRecreation(Recreation recreation);

    void updateRecreation(Recreation recreation);

    void deleteRecreation(Long id);

    List<Recreation> getAllEntriesList(CustomUser user);

    List<Recreation> findEntriesFromDate(CustomUser user, Date date);

    Recreation findLastEntry(CustomUser user);

}
