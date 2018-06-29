package mainpackage.entities.incomefinancestatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TotalIncomePerQuarterServiceImpl implements TotalIncomePerQuarterService {
    @Autowired
    private TotalIncomePerQuarterRepository totalIncomePerQuarterRepository;

    @Override
    @Transactional
    public void addTotalIncomePerQuarter(TotalIncomePerQuarter totalIncomePerQuarter) {
        totalIncomePerQuarterRepository.save(totalIncomePerQuarter);
    }

    @Override
    @Transactional
    public void updateTotalIncomePerQuarter(TotalIncomePerQuarter totalIncomePerQuarter) {
        totalIncomePerQuarterRepository.save(totalIncomePerQuarter);
    }

    @Override
    @Transactional
    public void deleteTotalIncomePerQuarter(Long id) {
        totalIncomePerQuarterRepository.delete(id);
    }

}
