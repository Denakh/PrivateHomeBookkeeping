package mainpackage.entities.income;

import mainpackage.entities.debt.Debt;
import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    @Transactional
    public void addIncome(Income income) {
        incomeRepository.save(income);
    }

    @Override
    @Transactional
    public void updateIncome(Income income) {
        incomeRepository.save(income);
    }

    @Override
    @Transactional
    public void deleteIncome(Long id) {
        incomeRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Income> getIncome() {
        return incomeRepository.findAll();
    }

    @Override
    public List<Income> findEntriesFromDate(CustomUser user, Date date) {
        return incomeRepository.findEntriesFromDate(user, date);
    }

}
