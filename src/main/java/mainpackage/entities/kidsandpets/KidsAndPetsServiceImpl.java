package mainpackage.entities.kidsandpets;

import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class KidsAndPetsServiceImpl implements KidsAndPetsService {
    @Autowired
    private KidsAndPetsRepository kidsAndPetsRepository;

    @Override
    @Transactional
    public void addKidsAndPets(KidsAndPets kidsAndPets) {
        kidsAndPetsRepository.save(kidsAndPets);
    }

    @Override
    @Transactional
    public void updateKidsAndPets(KidsAndPets kidsAndPets) {
        kidsAndPetsRepository.save(kidsAndPets);
    }

    @Override
    @Transactional
    public void deleteKidsAndPets(Long id) {
        kidsAndPetsRepository.delete(id);
    }

    @Override
    @Transactional
    public List<KidsAndPets> getAllEntriesList(CustomUser user) {
        return kidsAndPetsRepository.getAllEntriesList(user);
    }

    @Override
    @Transactional
    public List<KidsAndPets> findEntriesFromDate(CustomUser user, Date date) {
        return kidsAndPetsRepository.findEntriesFromDate(user, date);
    }

    @Override
    @Transactional
    public KidsAndPets findLastEntry(CustomUser user) {
        return kidsAndPetsRepository.findLastEntry(user);
    }

}
