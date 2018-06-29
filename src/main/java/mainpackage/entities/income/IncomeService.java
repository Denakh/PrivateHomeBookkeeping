package mainpackage.entities.income;

import java.util.List;

public interface IncomeService {

    void addIncome(Income income);

    void updateIncome(Income income);

    void deleteIncome(Long id);

    List<Income> getIncome();

}
