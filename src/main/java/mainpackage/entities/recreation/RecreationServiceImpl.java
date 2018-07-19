package mainpackage.entities.recreation;

import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RecreationServiceImpl implements RecreationService {
    @Autowired
    private RecreationRepository recreationRepository;

    @Override
    @Transactional
    public void addRecreation(Recreation recreation) {
        recreationRepository.save(recreation);
    }

    @Override
    @Transactional
    public void updateRecreation(Recreation recreation) {
        recreationRepository.save(recreation);
    }

    @Override
    @Transactional
    public void deleteRecreation(Long id) {
        recreationRepository.delete(id);
    }

    @Override
    public List<Recreation> getAllEntriesList(CustomUser user) {
        return recreationRepository.getAllEntriesList(user);
    }

    @Override
    public List<Recreation> findEntriesFromDate(CustomUser user, Date date) {
        return recreationRepository.findEntriesFromDate(user, date);
    }

    @Override
    @Transactional
    public Recreation findLastEntry(CustomUser user) {
        return recreationRepository.findLastEntry(user);
    }

}
