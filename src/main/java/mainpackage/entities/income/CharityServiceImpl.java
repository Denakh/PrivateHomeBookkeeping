package mainpackage.entities.income;

import mainpackage.entities.charity.Charity;
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
/*
    @Override
    @Transactional(readOnly = true)
    public CustomUser getUserByLogin(String login) {
        return charityRepository.findByLogin(login);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByLogin(String login) {
        return charityRepository.existsByLogin(login);
    }
*/

}
