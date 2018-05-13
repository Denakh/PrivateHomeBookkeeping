package mainpackage.entities.currentexpenses;

import mainpackage.entities.ItemOfExpenses;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CurrentExpenses extends ItemOfExpenses {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    private double estimatedAmount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

}
