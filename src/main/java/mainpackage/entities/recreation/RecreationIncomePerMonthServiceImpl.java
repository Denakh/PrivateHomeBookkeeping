package mainpackage.entities.recreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecreationIncomePerMonthServiceImpl implements RecreationIncomePerMonthService {
    @Autowired
    private RecreationIncomePerMonthRepository recreationIncomePerMonthRepository;

    @Override
    @Transactional
    public void addRecreationIncomePerMonth(RecreationIncomePerMonth recreationIncomePerMonth) {
        recreationIncomePerMonthRepository.save(recreationIncomePerMonth);
    }

    @Override
    @Transactional
    public void updateRecreationIncomePerMonth(RecreationIncomePerMonth recreationIncomePerMonth) {
        recreationIncomePerMonthRepository.save(recreationIncomePerMonth);
    }

    @Override
    @Transactional
    public void deleteRecreationIncomePerMonth(Long id) {
        recreationIncomePerMonthRepository.delete(id);
    }

}
