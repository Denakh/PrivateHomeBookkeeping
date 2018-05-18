package mainpackage.entities.othercapitaloutlays;

import mainpackage.entities.expensesfinancestatistics.CharityExpensesPerQuater;
import mainpackage.entities.expensesfinancestatistics.OtherCapitalOutlaysExpensesPerQuater;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OtherCapitalOutlays {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerQuater_id")
    private OtherCapitalOutlaysExpensesPerQuater otherCapitalOutlaysExpensesPerQuater;

    private double changeAmount;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private double amount;

    public OtherCapitalOutlays() {
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

    public OtherCapitalOutlaysExpensesPerQuater getOtherCapitalOutlaysExpensesPerQuater() {
        return otherCapitalOutlaysExpensesPerQuater;
    }

    public void setOtherCapitalOutlaysExpensesPerQuater(OtherCapitalOutlaysExpensesPerQuater otherCapitalOutlaysExpensesPerQuater) {
        this.otherCapitalOutlaysExpensesPerQuater = otherCapitalOutlaysExpensesPerQuater;
    }

    public double getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(double changeAmount) {
        this.changeAmount = changeAmount;
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
