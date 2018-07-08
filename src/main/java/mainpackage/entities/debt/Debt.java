package mainpackage.entities.debt;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Debt {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    private double amount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private boolean percentForInitialAm;

    private double percent;

    private double totalAmount;

    public Debt() {
    }

    public Debt(CustomUser user, double amount, Date date, String description, boolean percentForInitialAm, double percent, double totalAmount) {
        this.user = user;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.percentForInitialAm = percentForInitialAm;
        this.percent = percent;
        this.totalAmount = totalAmount;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public boolean isPercentForInitialAm() {
        return percentForInitialAm;
    }

    public void setPercentForInitialAm(boolean percentForInitialAm) {
        this.percentForInitialAm = percentForInitialAm;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
