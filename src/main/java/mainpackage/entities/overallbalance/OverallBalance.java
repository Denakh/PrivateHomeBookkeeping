package mainpackage.entities.overallbalance;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OverallBalance {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private double factualBalance;

    private double intriesBalance;

    public OverallBalance() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomUser getUser() {
        return user;
    }

    public void setUser(CustomUser user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getFactualBalance() {
        return factualBalance;
    }

    public void setFactualBalance(double factualBalance) {
        this.factualBalance = factualBalance;
    }

    public double getIntriesBalance() {
        return intriesBalance;
    }

    public void setIntriesBalance(double intriesBalance) {
        this.intriesBalance = intriesBalance;
    }

}
