package mainpackage.entities.income;

import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface IncomeService {

    void addIncome(Income income);

    void updateIncome(Income income);

    void deleteIncome(Long id);

    List<Income> getIncome();

    List<Income> findEntriesFromDate(CustomUser user, Date date);

    List<Income> findEntriesBetweenDates(CustomUser user, Date dateFrom, Date dateTo);

}
