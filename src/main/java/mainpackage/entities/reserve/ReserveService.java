package mainpackage.entities.reserve;

import mainpackage.entities.charity.Charity;

public interface ReserveService {

    void addReserve(Reserve reserve);

    void updateReserve(Reserve reserve);

    void deleteReserve(Long id);

    Reserve findLastEntry();

}
