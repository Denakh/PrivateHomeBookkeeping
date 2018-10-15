package mainpackage.entities.reserve;

import mainpackage.entities.users.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    private ReserveRepository reserveRepository;

    @Override
    @Transactional
    public void addReserve(Reserve reserve) {
        reserveRepository.save(reserve);
    }

    @Override
    @Transactional
    public void updateReserve(Reserve reserve) {
        reserveRepository.save(reserve);
    }

    @Override
    @Transactional
    public void deleteReserve(Long id) {
        reserveRepository.delete(id);
    }

    @Override
    @Transactional
    public List<Reserve> getAllEntriesList(CustomUser user) {
        return reserveRepository.getAllEntriesList(user);
    }

    @Override
    @Transactional
    public List<Reserve> findEntriesFromDate(CustomUser user, Date date) {
        return reserveRepository.findEntriesFromDate(user, date);
    }

    @Override
    @Transactional
    public Reserve findLastEntry(CustomUser user) {
        return reserveRepository.findLastEntry(user);
    }

}
