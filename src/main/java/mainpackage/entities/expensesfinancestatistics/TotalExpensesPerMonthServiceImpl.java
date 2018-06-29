package mainpackage.entities.expensesfinancestatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TotalExpensesPerMonthServiceImpl implements TotalExpensesPerMonthService {
    @Autowired
    private TotalExpensesPerMonthRepository totalExpensesPerMonthRepository;

    @Override
    @Transactional
    public void addTotalExpensesPerMonth(TotalExpensesPerMonth totalExpensesPerMonth) {
        totalExpensesPerMonthRepository.save(totalExpensesPerMonth);
    }

    @Override
    @Transactional
    public void updateTotalExpensesPerMonth(TotalExpensesPerMonth totalExpensesPerMonth) {
        totalExpensesPerMonthRepository.save(totalExpensesPerMonth);
    }

    @Override
    @Transactional
    public void deleteTotalExpensesPerMonth(Long id) {
        totalExpensesPerMonthRepository.delete(id);
    }

}
