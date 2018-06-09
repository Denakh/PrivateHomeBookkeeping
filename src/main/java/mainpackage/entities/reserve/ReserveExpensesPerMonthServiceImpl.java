package mainpackage.entities.reserve;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReserveExpensesPerMonthServiceImpl implements ReserveExpensesPerMonthService {
    @Autowired
    private ReserveExpensesPerMonthRepository reserveExpensesPerMonthRepository;

    @Override
    @Transactional
    public void addReserveExpensesPerMonth(ReserveExpensesPerMonth reserveExpensesPerMonth) {
        reserveExpensesPerMonthRepository.save(reserveExpensesPerMonth);
    }

    @Override
    @Transactional
    public void updateReserveExpensesPerMonth(ReserveExpensesPerMonth reserveExpensesPerMonth) {
        reserveExpensesPerMonthRepository.save(reserveExpensesPerMonth);
    }

    @Override
    @Transactional
    public void deleteReserveExpensesPerMonth(Long id) {
        reserveExpensesPerMonthRepository.delete(id);
    }

}
