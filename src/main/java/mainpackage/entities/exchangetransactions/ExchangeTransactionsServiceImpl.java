package mainpackage.entities.exchangetransactions;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExchangeTransactionsServiceImpl implements ExchangeTransactionsService {
    @Autowired
    private ExchangeTransactionsRepository exchangeTransactionsRepository;

    @Override
    @Transactional
    public void addExchangeTransactions(ExchangeTransactions exchangeTransactions) {
        exchangeTransactionsRepository.save(exchangeTransactions);
    }

    @Override
    @Transactional
    public void updateExchangeTransactions(ExchangeTransactions exchangeTransactions) {
        exchangeTransactionsRepository.save(exchangeTransactions);
    }

    @Override
    @Transactional
    public void deleteExchangeTransactions(Long id) {
        exchangeTransactionsRepository.delete(id);
    }

}
