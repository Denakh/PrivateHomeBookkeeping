package mainpackage.entities.recreation;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
