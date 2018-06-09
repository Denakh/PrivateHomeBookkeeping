package mainpackage.entities.income;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
