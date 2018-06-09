package mainpackage.entities.reserve;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReserveIncomePerQuarterServiceImpl implements ReserveIncomePerQuarterService {
    @Autowired
    private ReserveIncomePerQuarterRepository reserveIncomePerQuarterRepository;

    @Override
    @Transactional
    public void addReserveIncomePerQuarter(ReserveIncomePerQuarter reserveIncomePerQuarter) {
        reserveIncomePerQuarterRepository.save(reserveIncomePerQuarter);
    }

    @Override
    @Transactional
    public void updateReserveIncomePerQuarter(ReserveIncomePerQuarter reserveIncomePerQuarter) {
        reserveIncomePerQuarterRepository.save(reserveIncomePerQuarter);
    }

    @Override
    @Transactional
    public void deleteReserveIncomePerQuarter(Long id) {
        reserveIncomePerQuarterRepository.delete(id);
    }

}
