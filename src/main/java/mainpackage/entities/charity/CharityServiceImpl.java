package mainpackage.entities.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CharityServiceImpl implements CharityService {
    @Autowired
    private CharityRepository charityRepository;

    @Override
    @Transactional
    public void addCharity(Charity charity) {
        charityRepository.save(charity);
    }

    @Override
    @Transactional
    public void updateCharity(Charity charity) {
        charityRepository.save(charity);
    }

    @Override
    @Transactional
    public void deleteCharity(Long id) {
        charityRepository.delete(id);
    }

    @Override
    @Transactional
    public Charity findLastEntry() {
        return charityRepository.findLastEntry();
    }

}
