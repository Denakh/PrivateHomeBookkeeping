package mainpackage.entities.income;

import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface GeneralIncomeService {

    void addGeneralIncome(GeneralIncome generalIncome);

    void updateGeneralIncome(GeneralIncome generalIncome);

    void deleteGeneralIncome(Long id);

    GeneralIncome findLastEntry(CustomUser user);

    List<GeneralIncome> findEntriesFromDate(CustomUser user, Date date);

}
