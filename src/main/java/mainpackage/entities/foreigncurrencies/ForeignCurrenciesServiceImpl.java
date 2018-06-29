package mainpackage.entities.foreigncurrencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ForeignCurrenciesServiceImpl implements ForeignCurrenciesService {
    @Autowired
    private ForeignCurrenciesRepository foreignCurrenciesRepository;

    @Override
    @Transactional
    public void addForeignCurrencies(ForeignCurrencies foreignCurrencies) {
        foreignCurrenciesRepository.save(foreignCurrencies);
    }

    @Override
    @Transactional
    public void updateForeignCurrencies(ForeignCurrencies foreignCurrencies) {
        foreignCurrenciesRepository.save(foreignCurrencies);
    }

    @Override
    @Transactional
    public void deleteForeignCurrencies(Long id) {
        foreignCurrenciesRepository.delete(id);
    }

}
