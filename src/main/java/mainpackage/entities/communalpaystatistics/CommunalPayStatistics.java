package mainpackage.entities.communalpaystatistics;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CommunalPayStatistics {

    @Id
    @GeneratedValue
    private long id;

    private CustomUser user;

    private double amount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;


}
