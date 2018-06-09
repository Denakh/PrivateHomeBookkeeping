package mainpackage.entities.recreation;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecreationExpensesPerMonthServiceImpl implements RecreationExpensesPerMonthService {
    @Autowired
    private RecreationExpensesPerMonthRepository recreationExpensesPerMonthRepository;

    @Override
    @Transactional
    public void addRecreationExpensesPerMonth(RecreationExpensesPerMonth recreationExpensesPerMonth) {
        recreationExpensesPerMonthRepository.save(recreationExpensesPerMonth);
    }

    @Override
    @Transactional
    public void updateRecreationExpensesPerMonth(RecreationExpensesPerMonth recreationExpensesPerMonth) {
        recreationExpensesPerMonthRepository.save(recreationExpensesPerMonth);
    }

    @Override
    @Transactional
    public void deleteRecreationExpensesPerMonth(Long id) {
        recreationExpensesPerMonthRepository.delete(id);
    }

}
