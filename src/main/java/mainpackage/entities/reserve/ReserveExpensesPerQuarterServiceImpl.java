package mainpackage.entities.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReserveExpensesPerQuarterServiceImpl implements ReserveExpensesPerQuarterService {
    @Autowired
    private ReserveExpensesPerQuarterRepository reserveExpensesPerQuarterRepository;

    @Override
    @Transactional
    public void addReserveExpensesPerQuarter(ReserveExpensesPerQuarter reserveExpensesPerQuarter) {
        reserveExpensesPerQuarterRepository.save(reserveExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void updateReserveExpensesPerQuarter(ReserveExpensesPerQuarter reserveExpensesPerQuarter) {
        reserveExpensesPerQuarterRepository.save(reserveExpensesPerQuarter);
    }

    @Override
    @Transactional
    public void deleteReserveExpensesPerQuarter(Long id) {
        reserveExpensesPerQuarterRepository.delete(id);
    }

}
