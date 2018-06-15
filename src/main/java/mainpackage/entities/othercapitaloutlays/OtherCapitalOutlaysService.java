package mainpackage.entities.othercapitaloutlays;

import mainpackage.entities.charity.Charity;

public interface OtherCapitalOutlaysService {

    void addOtherCapitalOutlays(OtherCapitalOutlays otherCapitalOutlays);

    void updateOtherCapitalOutlays(OtherCapitalOutlays otherCapitalOutlays);

    void deleteOtherCapitalOutlays(Long id);

    OtherCapitalOutlays findLastEntry();

}
