package mainpackage.entities.charity;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Charity {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerQuarter_id")
    private CharityExpensesPerQuarter charityExpensesPerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerMonth_id")
    private CharityExpensesPerMonth charityExpensesPerMonth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerQuarter_id")
    private CharityIncomePerQuarter charityIncomePerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerMonth_id")
    private CharityIncomePerMonth charityIncomePerMonth;

    private double amountChange;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private double amount;

    public Charity() {
    }

    public Charity(CustomUser user, double amountChange, Date date, String description) {
        this.user = user;
        this.amountChange = amountChange;
        this.date = date;
        this.description = description;
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

    public CharityExpensesPerQuarter getCharityExpensesPerQuarter() {
        return charityExpensesPerQuarter;
    }

    public void setCharityExpensesPerQuarter(CharityExpensesPerQuarter charityExpensesPerQuarter) {
        this.charityExpensesPerQuarter = charityExpensesPerQuarter;
    }

    public CharityExpensesPerMonth getCharityExpensesPerMonth() {
        return charityExpensesPerMonth;
    }

    public void setCharityExpensesPerMonth(CharityExpensesPerMonth charityExpensesPerMonth) {
        this.charityExpensesPerMonth = charityExpensesPerMonth;
    }

    public CharityIncomePerQuarter getCharityIncomePerQuarter() {
        return charityIncomePerQuarter;
    }

    public void setCharityIncomePerQuarter(CharityIncomePerQuarter charityIncomePerQuarter) {
        this.charityIncomePerQuarter = charityIncomePerQuarter;
    }

    public CharityIncomePerMonth getCharityIncomePerMonth() {
        return charityIncomePerMonth;
    }

    public void setCharityIncomePerMonth(CharityIncomePerMonth charityIncomePerMonth) {
        this.charityIncomePerMonth = charityIncomePerMonth;
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
