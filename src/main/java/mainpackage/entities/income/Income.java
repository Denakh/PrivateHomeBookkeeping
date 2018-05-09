package mainpackage.entities.income;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Income {

    private double amount;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private IncPurpose purpose;



}
