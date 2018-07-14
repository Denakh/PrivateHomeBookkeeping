package mainpackage.entities.debt;

import mainpackage.entities.users.CustomUser;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DebtService {

    void addDebt(Debt debt);

    void updateDebt(Debt debt);

    void deleteDebt(Long id);

    Debt findLastEntry(CustomUser user);

    Debt findEntryById(CustomUser user, long id);

    List<Debt> findEffectiveDebtsList(CustomUser user);

}
