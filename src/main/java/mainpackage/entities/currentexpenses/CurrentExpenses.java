package mainpackage.entities.currentexpenses;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class CurrentExpenses {

    private double estimatedAmount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

}
