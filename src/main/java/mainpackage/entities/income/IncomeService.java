package mainpackage.entities.income;

import mainpackage.entities.charity.Charity;

public interface IncomeService {

    void addIncome(Income income);

    void updateIncome(Income income);

    void deleteIncome(Long id);

}
