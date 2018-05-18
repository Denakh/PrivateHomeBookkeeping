package mainpackage.entities.reserve;

import mainpackage.entities.expensesfinancestatistics.ReserveExpensesPerMonth;
import mainpackage.entities.expensesfinancestatistics.ReserveExpensesPerQuater;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reserve {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerQuater_id")
    private ReserveExpensesPerQuater reserveExpensesPerQuater;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerMonth_id")
    private ReserveExpensesPerMonth reserveExpensesPerMonth;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private double amount;

    public Reserve() {
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

    public ReserveExpensesPerQuater getReserveExpensesPerQuater() {
        return reserveExpensesPerQuater;
    }

    public void setReserveExpensesPerQuater(ReserveExpensesPerQuater reserveExpensesPerQuater) {
       this.reserveExpensesPerQuater = reserveExpensesPerQuater;
    }

    public ReserveExpensesPerMonth getReserveExpensesPerMonth() {
        return reserveExpensesPerMonth;
    }

    public void setReserveExpensesPerMonth(ReserveExpensesPerMonth reserveExpensesPerMonth) {
        this.reserveExpensesPerMonth = reserveExpensesPerMonth;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
