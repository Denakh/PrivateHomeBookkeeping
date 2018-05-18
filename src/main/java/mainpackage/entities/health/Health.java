package mainpackage.entities.health;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Health {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerQuarter_id")
    private HealthExpensesPerQuarter healthExpensesPerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerMonth_id")
    private HealthExpensesPerMonth healthExpensesPerMonth;

    private double changeAmount;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private double amount;

    public Health() {
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

    public HealthExpensesPerQuarter getHealthExpensesPerQuarter() {
        return healthExpensesPerQuarter;
    }

    public void setHealthExpensesPerQuarter(HealthExpensesPerQuarter healthExpensesPerQuarter) {
        this.healthExpensesPerQuarter = healthExpensesPerQuarter;
    }

    public HealthExpensesPerMonth getHealthExpensesPerMonth() {
        return healthExpensesPerMonth;
    }

    public void setHealthExpensesPerMonth(HealthExpensesPerMonth healthExpensesPerMonth) {
        this.healthExpensesPerMonth = healthExpensesPerMonth;
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
