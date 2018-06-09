package mainpackage.entities.foreigncurrencies;

import mainpackage.entities.charity.Charity;

public interface ForeignCurrenciesService {

    void addForeignCurrencies(ForeignCurrencies foreignCurrencies);

    void updateForeignCurrencies(ForeignCurrencies foreignCurrencies);

    void deleteForeignCurrencies(Long id);

}
