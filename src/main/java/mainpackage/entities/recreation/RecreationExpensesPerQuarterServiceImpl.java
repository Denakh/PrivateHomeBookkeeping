package mainpackage.entities.recreation;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecreationExpensesPerQuarterServiceImpl implements RecreationExpensesPerQuarterService {
    @Autowired
    private RecreationExpensesPerQuarterRepository recreationExpensesPerQuarterRepository;

    @Override
    @Transactional
    public void addRecreationExpensesPerQuarter(RecreationExpensesPerQuarter recreationExpensesPerQuarter) {
        recreationExpensesPerQuarterRepository.save(recreationExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void updateRecreationExpensesPerQuarter(RecreationExpensesPerQuarter recreationExpensesPerQuarter) {
        recreationExpensesPerQuarterRepository.save(recreationExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void deleteRecreationExpensesPerQuarter(Long id) {
        recreationExpensesPerQuarterRepository.delete(id);
    }

}
