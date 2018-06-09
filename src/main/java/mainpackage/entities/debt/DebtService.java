package mainpackage.entities.debt;

import mainpackage.entities.charity.Charity;

public interface DebtService {

    void addDebt(Debt debt);

    void updateDebt(Debt debt);

    void deleteDebt(Long id);

}
