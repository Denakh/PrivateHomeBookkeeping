package mainpackage.entities.overallbalance;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class OverallBalance {

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private double factualBalance;

    private double intriesBalance;



}
