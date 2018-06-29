package mainpackage.entities.recreation;

public interface RecreationService {

    void addRecreation(Recreation recreation);

    void updateRecreation(Recreation recreation);

    void deleteRecreation(Long id);

    Recreation findLastEntry();

}
