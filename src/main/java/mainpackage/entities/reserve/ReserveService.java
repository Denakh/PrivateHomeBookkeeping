package mainpackage.entities.reserve;

public interface ReserveService {

    void addReserve(Reserve reserve);

    void updateReserve(Reserve reserve);

    void deleteReserve(Long id);

    Reserve findLastEntry();

}
