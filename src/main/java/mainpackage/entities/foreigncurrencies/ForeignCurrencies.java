package mainpackage.entities.foreigncurrencies;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ForeignCurrencies {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    @Enumerated(EnumType.STRING)
    private Currencies currency;

    private double amount;

    private double conventionalExchangeRate;

}
