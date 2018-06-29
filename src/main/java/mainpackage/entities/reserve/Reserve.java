package mainpackage.entities.reserve;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reserve {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerQuarter_id")
    private ReserveExpensesPerQuarter reserveExpensesPerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerMonth_id")
    private ReserveExpensesPerMonth reserveExpensesPerMonth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerQuarter_id")
    private ReserveIncomePerQuarter reserveIncomePerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerMonth_id")
    private ReserveIncomePerMonth reserveIncomePerMonth;

    private double amountChange;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private double amount;

    public Reserve() {
    }

    public Reserve(CustomUser user, double amountChange, Date date, String description, double amount) {
        this.user = user;
        this.amountChange = amountChange;
        this.date = date;
        this.description = description;
        this.amount = amount;
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

    public ReserveExpensesPerQuarter getReserveExpensesPerQuarter() {
        return reserveExpensesPerQuarter;
    }

    public void setReserveExpensesPerQuarter(ReserveExpensesPerQuarter reserveExpensesPerQuarter) {
        this.reserveExpensesPerQuarter = reserveExpensesPerQuarter;
    }

    public ReserveExpensesPerMonth getReserveExpensesPerMonth() {
        return reserveExpensesPerMonth;
    }

    public void setReserveExpensesPerMonth(ReserveExpensesPerMonth reserveExpensesPerMonth) {
        this.reserveExpensesPerMonth = reserveExpensesPerMonth;
    }

    public ReserveIncomePerQuarter getReserveIncomePerQuarter() {
        return reserveIncomePerQuarter;
    }

    public void setReserveIncomePerQuarter(ReserveIncomePerQuarter reserveIncomePerQuarter) {
        this.reserveIncomePerQuarter = reserveIncomePerQuarter;
    }

    public ReserveIncomePerMonth getReserveIncomePerMonth() {
        return reserveIncomePerMonth;
    }

    public void setReserveIncomePerMonth(ReserveIncomePerMonth reserveIncomePerMonth) {
        this.reserveIncomePerMonth = reserveIncomePerMonth;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmountChange() {
        return amountChange;
    }

    public void setAmountChange(double amountChange) {
        this.amountChange = amountChange;
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
