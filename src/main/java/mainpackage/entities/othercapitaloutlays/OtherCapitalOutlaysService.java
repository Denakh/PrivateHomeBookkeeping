package mainpackage.entities.othercapitaloutlays;

import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface OtherCapitalOutlaysService {

    void addOtherCapitalOutlays(OtherCapitalOutlays otherCapitalOutlays);

    void updateOtherCapitalOutlays(OtherCapitalOutlays otherCapitalOutlays);

    void deleteOtherCapitalOutlays(Long id);

    List<OtherCapitalOutlays> getAllEntriesList(CustomUser user);

    List<OtherCapitalOutlays> findEntriesFromDate(CustomUser user, Date date);

    OtherCapitalOutlays findLastEntry(CustomUser user);

}
