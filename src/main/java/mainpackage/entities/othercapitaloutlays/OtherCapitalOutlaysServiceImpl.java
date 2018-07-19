package mainpackage.entities.othercapitaloutlays;

import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OtherCapitalOutlaysServiceImpl implements OtherCapitalOutlaysService {
    @Autowired
    private OtherCapitalOutlaysRepository otherCapitalOutlaysRepository;

    @Override
    @Transactional
    public void addOtherCapitalOutlays(OtherCapitalOutlays otherCapitalOutlays) {
        otherCapitalOutlaysRepository.save(otherCapitalOutlays);
    }

    @Override
    @Transactional
    public void updateOtherCapitalOutlays(OtherCapitalOutlays otherCapitalOutlays) {
        otherCapitalOutlaysRepository.save(otherCapitalOutlays);
    }

    @Override
    @Transactional
    public void deleteOtherCapitalOutlays(Long id) {
        otherCapitalOutlaysRepository.delete(id);
    }

    @Override
    public List<OtherCapitalOutlays> getAllEntriesList(CustomUser user) {
        return otherCapitalOutlaysRepository.getAllEntriesList(user);
    }

    @Override
    public List<OtherCapitalOutlays> findEntriesFromDate(CustomUser user, Date date) {
        return otherCapitalOutlaysRepository.findEntriesFromDate(user, date);
    }

    @Override
    @Transactional
    public OtherCapitalOutlays findLastEntry(CustomUser user) {
        return otherCapitalOutlaysRepository.findLastEntry(user);
    }

}
