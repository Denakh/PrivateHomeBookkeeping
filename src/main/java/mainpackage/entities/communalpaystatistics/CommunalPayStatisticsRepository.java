package mainpackage.entities.communalpaystatistics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunalPayStatisticsRepository extends JpaRepository<CommunalPayStatistics, Long> {


    /*
    @Query("SELECT u FROM CustomUser u where u.login = :login")
    CustomUser findByLogin(@Param("login") String login);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM CustomUser u WHERE u.login = :login")
    boolean existsByLogin(@Param("login") String login);
    */
}
