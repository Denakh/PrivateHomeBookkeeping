package mainpackage.entities.allocationofprofits;

import mainpackage.entities.charity.Charity;

public interface AllocationOfProfitsService {

    void addAllocationOfProfits(AllocationOfProfits allocationOfProfits);

    void updateAllocationOfProfits(AllocationOfProfits allocationOfProfits);

    void deleteAllocationOfProfits(Long id);

}
