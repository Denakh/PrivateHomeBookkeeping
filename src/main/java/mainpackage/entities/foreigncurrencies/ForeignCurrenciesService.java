package mainpackage.entities.foreigncurrencies;

import mainpackage.entities.users.CustomUser;

import java.util.List;

public interface ForeignCurrenciesService {

    void addForeignCurrencies(ForeignCurrencies foreignCurrencies);

    void updateForeignCurrencies(ForeignCurrencies foreignCurrencies);

    void deleteForeignCurrencies(Long id);

    List<ForeignCurrencies> getAllEntriesList(CustomUser user);

}
