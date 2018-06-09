package mainpackage.entities.exchangetransactions;

import mainpackage.entities.charity.Charity;

public interface ExchangeTransactionsService {

    void addExchangeTransactions(ExchangeTransactions exchangeTransactions);

    void updateExchangeTransactions(ExchangeTransactions exchangeTransactions);

    void deleteExchangeTransactions(Long id);

}
