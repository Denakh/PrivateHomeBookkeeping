package mainpackage.entities.othercapitaloutlays;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class OtherCapitalOutlays {

    private double change;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private double amount;

}
