package mainpackage.entities.recreation;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Recreation {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerQuarter_id")
    private RecreationExpensesPerQuarter recreationExpensesPerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerMonth_id")
    private RecreationExpensesPerMonth recreationExpensesPerMonth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerQuarter_id")
    private RecreationIncomePerQuarter recreationIncomePerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerMonth_id")
    private RecreationIncomePerMonth recreationIncomePerMonth;

    private double amountChange;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private double amount;

    public Recreation() {
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

    public RecreationExpensesPerQuarter getRecreationExpensesPerQuarter() {
        return recreationExpensesPerQuarter;
    }

    public void setRecreationExpensesPerQuarter(RecreationExpensesPerQuarter recreationExpensesPerQuarter) {
        this.recreationExpensesPerQuarter = recreationExpensesPerQuarter;
    }

    public RecreationExpensesPerMonth getRecreationExpensesPerMonth() {
        return recreationExpensesPerMonth;
    }

    public void setRecreationExpensesPerMonth(RecreationExpensesPerMonth recreationExpensesPerMonth) {
        this.recreationExpensesPerMonth = recreationExpensesPerMonth;
    }

    public RecreationIncomePerQuarter getRecreationIncomePerQuarter() {
        return recreationIncomePerQuarter;
    }

    public void setRecreationIncomePerQuarter(RecreationIncomePerQuarter recreationIncomePerQuarter) {
        this.recreationIncomePerQuarter = recreationIncomePerQuarter;
    }

    public RecreationIncomePerMonth getRecreationIncomePerMonth() {
        return recreationIncomePerMonth;
    }

    public void setRecreationIncomePerMonth(RecreationIncomePerMonth recreationIncomePerMonth) {
        this.recreationIncomePerMonth = recreationIncomePerMonth;
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
