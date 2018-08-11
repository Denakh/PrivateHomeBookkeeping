package mainpackage.entities.mainfinancestatistic;

import mainpackage.entities.charity.Charity;
import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MainFinanceStatisticServiceImpl implements MainFinanceStatisticService {
    @Autowired
    private MainFinanceStatisticRepository mainFinanceStatisticRepository;

    @Override
    @Transactional
    public void addMainFinanceStatistic(MainFinanceStatistic mainFinanceStatistic) {
        mainFinanceStatisticRepository.save(mainFinanceStatistic);
    }

    @Override
    @Transactional
    public void updateMainFinanceStatistic(MainFinanceStatistic mainFinanceStatistic) {
        mainFinanceStatisticRepository.save(mainFinanceStatistic);
    }

    @Override
    @Transactional
    public void deleteMainFinanceStatistic(Long id) {
        mainFinanceStatisticRepository.delete(id);
    }

    @Override
    public List<MainFinanceStatistic> findAllEntries(CustomUser user) {
        return mainFinanceStatisticRepository.findAllEntries(user);
    }

}
