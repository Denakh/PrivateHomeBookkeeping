package mainpackage.entities.reserve;

import mainpackage.entities.charity.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
