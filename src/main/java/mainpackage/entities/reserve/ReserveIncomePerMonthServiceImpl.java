package mainpackage.entities.reserve;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReserveIncomePerMonthServiceImpl implements ReserveIncomePerMonthService {
    @Autowired
    private ReserveIncomePerMonthRepository reserveIncomePerMonthRepository;

    @Override
    @Transactional
    public void addReserveIncomePerMonth(ReserveIncomePerMonth reserveIncomePerMonth) {
        reserveIncomePerMonthRepository.save(reserveIncomePerMonth);
    }

    @Override
    @Transactional
    public void updateReserveIncomePerMonth(ReserveIncomePerMonth reserveIncomePerMonth) {
        reserveIncomePerMonthRepository.save(reserveIncomePerMonth);
    }

    @Override
    @Transactional
    public void deleteReserveIncomePerMonth(Long id) {
        reserveIncomePerMonthRepository.delete(id);
    }

}
