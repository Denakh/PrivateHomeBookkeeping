package mainpackage.entities.foreigncurrencies;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ForeignCurrencies {

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private Currencies currency;

    private double amount;

    private double conventionalExchangeRate;

}
