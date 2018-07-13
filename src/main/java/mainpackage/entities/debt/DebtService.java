package mainpackage.entities.debt;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.repository.query.Param;

public interface DebtService {

    void addDebt(Debt debt);

    void updateDebt(Debt debt);

    void deleteDebt(Long id);

    Debt findLastEntry(CustomUser user);

    Debt findEntryById(long id);

}
