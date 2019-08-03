package mainpackage.entities.foreigncurrenciesoperations;

import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ForeignCurrenciesOperationServiceImpl implements ForeignCurrenciesOperationService {

    @Autowired
    private ForeignCurrenciesOperationRepository foreignCurrenciesOperationRepository;

    @Override
    @Transactional
    public void addForeignCurrenciesOperation(ForeignCurrenciesOperation foreignCurrenciesOperation) {
        foreignCurrenciesOperationRepository.save(foreignCurrenciesOperation);
    }

    @Override
    @Transactional
    public void updateForeignCurrenciesOperation(ForeignCurrenciesOperation foreignCurrenciesOperation) {
        foreignCurrenciesOperationRepository.save(foreignCurrenciesOperation);
    }

    @Override
    @Transactional
    public void deleteForeignCurrenciesOperation(Long id) {
        foreignCurrenciesOperationRepository.delete(id);
    }

    @Override
    @Transactional
    public List<ForeignCurrenciesOperation> getAllEntriesList(CustomUser user) {
        return foreignCurrenciesOperationRepository.getAllEntriesList(user);
    }

    @Override
    @Transactional
    public List<ForeignCurrenciesOperation> findEntriesFromDate(CustomUser user, Date date) {
        return foreignCurrenciesOperationRepository.findEntriesFromDate(user, date);
    }

}
