package mainpackage.entities.debt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
