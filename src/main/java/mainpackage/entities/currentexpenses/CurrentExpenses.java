package mainpackage.entities.currentexpenses;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CurrentExpenses {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerQuarter_id")
    private CurrentExpensesPerQuarter currentExpensesPerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerMonth_id")
    private CurrentExpensesPerMonth currentExpensesPerMonth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerQuarter_id")
    private CurrentExpensesIncomePerQuarter currentExpensesIncomePerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerMonth_id")
    private CurrentExpensesIncomePerMonth currentExpensesIncomePerMonth;

    private double estimatedAmount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    public CurrentExpenses() {
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

    public CurrentExpensesPerQuarter getCurrentExpensesPerQuarter() {
        return currentExpensesPerQuarter;
    }

    public void setCurrentExpensesPerQuarter(CurrentExpensesPerQuarter currentExpensesPerQuarter) {
        this.currentExpensesPerQuarter = currentExpensesPerQuarter;
    }

    public CurrentExpensesPerMonth getCurrentExpensesPerMonth() {
        return currentExpensesPerMonth;
    }

    public void setCurrentExpensesPerMonth(CurrentExpensesPerMonth currentExpensesPerMonth) {
        this.currentExpensesPerMonth = currentExpensesPerMonth;
    }

    public CurrentExpensesIncomePerQuarter getCurrentExpensesIncomePerQuarter() {
        return currentExpensesIncomePerQuarter;
    }

    public void setCurrentExpensesIncomePerQuarter(CurrentExpensesIncomePerQuarter currentExpensesIncomePerQuarter) {
        this.currentExpensesIncomePerQuarter = currentExpensesIncomePerQuarter;
    }

    public CurrentExpensesIncomePerMonth getCurrentExpensesIncomePerMonth() {
        return currentExpensesIncomePerMonth;
    }

    public void setCurrentExpensesIncomePerMonth(CurrentExpensesIncomePerMonth currentExpensesIncomePerMonth) {
        this.currentExpensesIncomePerMonth = currentExpensesIncomePerMonth;
    }

    public double getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
