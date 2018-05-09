package mainpackage.entities.debt;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Debt {

    private double amount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    boolean percentForInitialAm

}
