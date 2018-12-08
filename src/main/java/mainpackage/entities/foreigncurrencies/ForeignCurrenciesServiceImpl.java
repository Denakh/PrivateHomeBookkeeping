package mainpackage.entities.foreigncurrencies;

import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional
    public List<ForeignCurrencies> getAllEntriesList(CustomUser user) {
        return foreignCurrenciesRepository.getAllEntriesList(user);
    }

    @Override
    @Transactional
    public ForeignCurrencies findEntryByCurrency(CustomUser user, Currencies currency) {
        return foreignCurrenciesRepository.findEntryByCurrency(user, currency);
    }

}
