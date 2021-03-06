package mainpackage.entities.debt;

import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DebtServiceImpl implements DebtService {
    @Autowired
    private DebtRepository debtRepository;

    @Override
    @Transactional
    public void addDebt(Debt debt) {
        debtRepository.save(debt);
    }

    @Override
    @Transactional
    public void updateDebt(Debt debt) {
        debtRepository.save(debt);
    }

    @Override
    @Transactional
    public void deleteDebt(Long id) {
        debtRepository.delete(id);
    }

    @Override
    @Transactional
    public Debt findLastEntry(CustomUser user) {
        return debtRepository.findLastEntry(user);
    }

    @Override
    @Transactional
    public Debt findEntryById(CustomUser user, long id) {
        return debtRepository.findEntryById(user, id);
    }

    @Override
    @Transactional
    public List<Debt> findEffectiveDebtsList(CustomUser user) {
        return debtRepository.findEffectiveDebtsList(user);
    }

    @Override
    @Transactional
    public List<Debt> findEntriesFromDate(CustomUser user, Date date) {
        return debtRepository.findEntriesFromDate(user, date);
    }

}
