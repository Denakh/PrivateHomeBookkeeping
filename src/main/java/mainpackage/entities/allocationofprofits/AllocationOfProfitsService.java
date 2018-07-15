package mainpackage.entities.allocationofprofits;

import mainpackage.entities.users.CustomUser;

public interface AllocationOfProfitsService {

    void addAllocationOfProfits(AllocationOfProfits allocationOfProfits);

    void updateAllocationOfProfits(AllocationOfProfits allocationOfProfits);

    void deleteAllocationOfProfits(Long id);

    AllocationOfProfits findLastEntry(CustomUser user);

}
