package mainpackage.entities.deferrals;

import mainpackage.entities.income.Income;
import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DeferralsServiceImpl implements DeferralsService {
    @Autowired
    private DeferralsRepository deferralsRepository;

    @Override
    @Transactional
    public void addDeferrals(Deferrals deferrals) {
        deferralsRepository.save(deferrals);
    }

    @Override
    @Transactional
    public void updateDeferrals(Deferrals deferrals) {
        deferralsRepository.save(deferrals);
    }

    @Override
    @Transactional
    public void deleteDeferrals(Long id) {
        deferralsRepository.delete(id);
    }

    @Override
    @Transactional
    public List<Deferrals> findEntriesFromDate(CustomUser user, Date date) {
        return deferralsRepository.findEntriesFromDate(user, date);
    }

}
