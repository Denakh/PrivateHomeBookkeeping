package mainpackage.entities.othercapitaloutlays;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
