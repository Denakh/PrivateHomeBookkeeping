package mainpackage.entities.allocationofprofits;

import mainpackage.entities.income.GeneralIncome;

public interface AllocationOfProfitsService {

    void addAllocationOfProfits(AllocationOfProfits allocationOfProfits);

    void updateAllocationOfProfits(AllocationOfProfits allocationOfProfits);

    void deleteAllocationOfProfits(Long id);

    AllocationOfProfits findLastEntry();

}
