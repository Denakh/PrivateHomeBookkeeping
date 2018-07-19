package mainpackage.entities.reserve;

import mainpackage.entities.users.CustomUser;

import java.util.Date;
import java.util.List;

public interface ReserveService {

    void addReserve(Reserve reserve);

    void updateReserve(Reserve reserve);

    void deleteReserve(Long id);

    List<Reserve> getAllEntriesList(CustomUser user);

    List<Reserve> findEntriesFromDate(CustomUser user, Date date);

    Reserve findLastEntry(CustomUser user);

}
