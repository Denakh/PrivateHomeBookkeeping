package mainpackage.entities.deferrals;

import mainpackage.entities.income.Income;
import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface DeferralsService {

    void addDeferrals(Deferrals deferrals);

    void updateDeferrals(Deferrals deferrals);

    void deleteDeferrals(Long id);

    List<Deferrals> findEntriesFromDate(CustomUser user, Date date);

}
