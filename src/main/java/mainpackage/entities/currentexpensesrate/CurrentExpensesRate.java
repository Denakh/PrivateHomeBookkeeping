package mainpackage.entities.currentexpensesrate;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;

//@Entity
public class CurrentExpensesRate {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    @Enumerated(EnumType.STRING)
    private MonthEn month;

    private double amount;

    public CurrentExpensesRate() {
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

    public MonthEn getMonth() {
        return month;
    }

    public void setMonth(MonthEn month) {
        this.month = month;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
