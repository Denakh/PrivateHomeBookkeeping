package mainpackage.entities.income;

import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneralIncomeServiceImpl implements GeneralIncomeService {
    @Autowired
    private GeneralIncomeRepository generalIncomeRepository;

    @Override
    @Transactional
    public void addGeneralIncome(GeneralIncome generalIncome) {
        generalIncomeRepository.save(generalIncome);
    }

    @Override
    @Transactional
    public void updateGeneralIncome(GeneralIncome generalIncome) {
        generalIncomeRepository.save(generalIncome);
    }

    @Override
    @Transactional
    public void deleteGeneralIncome(Long id) {
        generalIncomeRepository.delete(id);
    }

    @Override
    @Transactional
    public GeneralIncome findLastEntry(CustomUser user) {
        return generalIncomeRepository.findLastEntry(user);
    }

}
