package mainpackage.entities.deferrals;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
