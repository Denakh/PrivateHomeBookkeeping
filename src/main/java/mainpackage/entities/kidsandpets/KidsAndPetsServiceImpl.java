package mainpackage.entities.kidsandpets;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public KidsAndPets findLastEntry() {
        return kidsAndPetsRepository.findLastEntry();
    }

}
