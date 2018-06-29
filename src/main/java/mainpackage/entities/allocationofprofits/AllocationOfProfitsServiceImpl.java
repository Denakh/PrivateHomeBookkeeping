package mainpackage.entities.allocationofprofits;

import mainpackage.entities.income.GeneralIncome;
import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AllocationOfProfitsServiceImpl implements AllocationOfProfitsService {
    @Autowired
    private AllocationOfProfitsRepository allocationOfProfitsRepository;

    @Override
    @Transactional
    public void addAllocationOfProfits(AllocationOfProfits allocationOfProfits) {
        allocationOfProfitsRepository.save(allocationOfProfits);
    }

    @Override
    @Transactional
    public void updateAllocationOfProfits(AllocationOfProfits allocationOfProfits) {
        allocationOfProfitsRepository.save(allocationOfProfits);
    }

    @Override
    @Transactional
    public void deleteAllocationOfProfits(Long id) {
        allocationOfProfitsRepository.delete(id);
    }

    @Override
    @Transactional
    public AllocationOfProfits findLastEntry(CustomUser user) {
        return allocationOfProfitsRepository.findLastEntry(user);
    }

}
