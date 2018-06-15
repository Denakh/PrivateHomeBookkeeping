package mainpackage.entities.recreation;

import mainpackage.entities.charity.Charity;

public interface RecreationService {

    void addRecreation(Recreation recreation);

    void updateRecreation(Recreation recreation);

    void deleteRecreation(Long id);

    Recreation findLastEntry();

}
