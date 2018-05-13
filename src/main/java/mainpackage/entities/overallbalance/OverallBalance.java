package mainpackage.entities.overallbalance;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OverallBalance {

    @Id
    @GeneratedValue
    private long id;

    private CustomUser user;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private double factualBalance;

    private double intriesBalance;


}
