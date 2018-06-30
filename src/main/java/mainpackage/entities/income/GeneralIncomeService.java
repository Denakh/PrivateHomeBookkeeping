package mainpackage.entities.income;

import mainpackage.entities.users.CustomUser;

public interface GeneralIncomeService {

    void addGeneralIncome(GeneralIncome generalIncome);

    void updateGeneralIncome(GeneralIncome generalIncome);

    void deleteGeneralIncome(Long id);

    GeneralIncome findLastEntry(CustomUser user);

}
