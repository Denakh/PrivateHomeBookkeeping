package mainpackage.entities.allocationofprofits;

import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface AllocationOfProfitsService {

    void addAllocationOfProfits(AllocationOfProfits allocationOfProfits);

    void updateAllocationOfProfits(AllocationOfProfits allocationOfProfits);

    void deleteAllocationOfProfits(Long id);

    AllocationOfProfits findLastEntry(CustomUser user);

    List<AllocationOfProfits> findEntriesFromDate(CustomUser user, Date date);

}
