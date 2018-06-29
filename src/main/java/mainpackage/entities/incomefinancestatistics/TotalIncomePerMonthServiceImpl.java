package mainpackage.entities.incomefinancestatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TotalIncomePerMonthServiceImpl implements TotalIncomePerMonthService {
    @Autowired
    private TotalIncomePerMonthRepository totalIncomePerMonthRepository;

    @Override
    @Transactional
    public void addTotalIncomePerMonth(TotalIncomePerMonth totalIncomePerMonth) {
        totalIncomePerMonthRepository.save(totalIncomePerMonth);
    }

    @Override
    @Transactional
    public void updateTotalIncomePerMonth(TotalIncomePerMonth totalIncomePerMonth) {
        totalIncomePerMonthRepository.save(totalIncomePerMonth);
    }

    @Override
    @Transactional
    public void deleteTotalIncomePerMonth(Long id) {
        totalIncomePerMonthRepository.delete(id);
    }

}
