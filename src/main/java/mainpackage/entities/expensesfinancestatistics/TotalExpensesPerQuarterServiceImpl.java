package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TotalExpensesPerQuarterServiceImpl implements TotalExpensesPerQuarterService {
    @Autowired
    private TotalExpensesPerQuarterRepository totalExpensesPerQuarterRepository;

    @Override
    @Transactional
    public void addTotalExpensesPerQuarter(TotalExpensesPerQuarter totalExpensesPerQuarter) {
        totalExpensesPerQuarterRepository.save(totalExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void updateTotalExpensesPerQuarter(TotalExpensesPerQuarter totalExpensesPerQuarter) {
        totalExpensesPerQuarterRepository.save(totalExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void deleteTotalExpensesPerQuarter(Long id) {
        totalExpensesPerQuarterRepository.delete(id);
    }

}
