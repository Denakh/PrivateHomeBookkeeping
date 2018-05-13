package mainpackage.entities.income;

import mainpackage.entities.ItemOfExpenses;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Income {

    @Id
    @GeneratedValue
    private long id;

    private CustomUser user;

    private double amount;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private ItemOfExpenses purpose;


}
