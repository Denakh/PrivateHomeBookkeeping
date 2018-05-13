package mainpackage.entities.recreation;

import mainpackage.entities.ItemOfExpenses;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Recreation extends ItemOfExpenses {

    @Id
    @GeneratedValue
    private long id;

    private CustomUser user;

    private double change;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private double amount;


}
