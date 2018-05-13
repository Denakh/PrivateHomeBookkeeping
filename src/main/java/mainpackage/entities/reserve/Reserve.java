package mainpackage.entities.reserve;

import mainpackage.entities.ItemOfExpenses;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Reserve extends ItemOfExpenses {

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private double amount;

}
