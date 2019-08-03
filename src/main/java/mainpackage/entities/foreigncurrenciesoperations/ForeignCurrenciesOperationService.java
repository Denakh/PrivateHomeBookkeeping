package mainpackage.entities.foreigncurrenciesoperations;

import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface ForeignCurrenciesOperationService {

    void addForeignCurrenciesOperation(ForeignCurrenciesOperation foreignCurrenciesOperation);

    void updateForeignCurrenciesOperation(ForeignCurrenciesOperation foreignCurrenciesOperation);

    void deleteForeignCurrenciesOperation(Long id);

    List<ForeignCurrenciesOperation> getAllEntriesList(CustomUser user);

    List<ForeignCurrenciesOperation> findEntriesFromDate(CustomUser user, Date date);

}
