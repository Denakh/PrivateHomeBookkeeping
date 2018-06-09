package mainpackage.entities.recreation;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecreationIncomePerQuarterServiceImpl implements RecreationIncomePerQuarterService {
    @Autowired
    private RecreationIncomePerQuarterRepository recreationIncomePerQuarterRepository;

    @Override
    @Transactional
    public void addRecreationIncomePerQuarter(RecreationIncomePerQuarter recreationIncomePerQuarter) {
        recreationIncomePerQuarterRepository.save(recreationIncomePerQuarter);
    }

    @Override
    @Transactional
    public void updateRecreationIncomePerQuarter(RecreationIncomePerQuarter recreationIncomePerQuarter) {
        recreationIncomePerQuarterRepository.save(recreationIncomePerQuarter);
    }

    @Override
    @Transactional
    public void deleteRecreationIncomePerQuarter(Long id) {
        recreationIncomePerQuarterRepository.delete(id);
    }

}
