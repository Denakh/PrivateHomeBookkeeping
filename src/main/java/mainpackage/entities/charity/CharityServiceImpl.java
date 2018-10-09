package mainpackage.entities.charity;

import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
    public List<Charity> getAllEntriesList(CustomUser user) {
        return charityRepository.getAllEntriesList(user);
    }

    @Override
    @Transactional
    public List<Charity> findEntriesFromDate(CustomUser user, Date date) {
        return charityRepository.findEntriesFromDate(user, date);
    }

    @Override
    @Transactional
    public Charity findLastEntry(CustomUser user) {
        return charityRepository.findLastEntry(user);
    }

}
