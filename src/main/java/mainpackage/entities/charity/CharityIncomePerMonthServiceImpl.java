package mainpackage.entities.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CharityIncomePerMonthServiceImpl implements CharityIncomePerMonthService {
    @Autowired
    private CharityIncomePerMonthRepository charityIncomePerMonthRepository;

    @Override
    @Transactional
    public void addCharityIncomePerMonth(CharityIncomePerMonth charityIncomePerMonth) {
        charityIncomePerMonthRepository.save(charityIncomePerMonth);
    }

    @Override
    @Transactional
    public void updateCharityIncomePerMonth(CharityIncomePerMonth charityIncomePerMonth) {
        charityIncomePerMonthRepository.save(charityIncomePerMonth);
    }

    @Override
    @Transactional
    public void deleteCharityIncomePerMonth(Long id) {
        charityIncomePerMonthRepository.delete(id);
    }

}
