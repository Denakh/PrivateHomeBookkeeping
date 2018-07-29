package mainpackage.entities.currentexpenses;

import mainpackage.entities.charity.Charity;
import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface CurrentExpensesService {

    void addCurrentExpenses(CurrentExpenses currentExpenses);

    void updateCurrentExpenses(CurrentExpenses currentExpenses);

    void deleteCurrentExpenses(Long id);

    List<CurrentExpenses> findEntriesFromDate(CustomUser user, Date date);

}
