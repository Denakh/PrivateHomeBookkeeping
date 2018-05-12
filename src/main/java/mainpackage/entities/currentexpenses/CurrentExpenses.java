package mainpackage.entities.currentexpenses;

import mainpackage.entities.ItemOfExpenses;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class CurrentExpenses extends ItemOfExpenses {

    private double estimatedAmount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

}
