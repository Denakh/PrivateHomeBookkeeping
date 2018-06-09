package mainpackage.entities.deferrals;

import mainpackage.entities.charity.Charity;

public interface DeferralsService {

    void addDeferrals(Deferrals deferrals);

    void updateDeferrals(Deferrals deferrals);

    void deleteDeferrals(Long id);

}
