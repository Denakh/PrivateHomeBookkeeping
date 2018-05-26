package mainpackage.entities.othercapitaloutlays;

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
    @JoinColumn(name = "expensesPerQuarter_id")
    private OtherCapitalOutlaysExpensesPerQuarter otherCapitalOutlaysExpensesPerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerMonth_id")
    private OtherCapitalOutlaysExpensesPerMonth otherCapitalOutlaysExpensesPerMonth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerQuarter_id")
    private OtherCapitalOutlaysIncomePerQuarter otherCapitalOutlaysIncomePerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerMonth_id")
    private OtherCapitalOutlaysIncomePerMonth otherCapitalOutlaysIncomePerMonth;

    private double changeAmount;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private double amountChange;

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

    public OtherCapitalOutlaysExpensesPerQuarter getOtherCapitalOutlaysExpensesPerQuarter() {
        return otherCapitalOutlaysExpensesPerQuarter;
    }

    public void setOtherCapitalOutlaysExpensesPerQuarter(OtherCapitalOutlaysExpensesPerQuarter otherCapitalOutlaysExpensesPerQuarter) {
        this.otherCapitalOutlaysExpensesPerQuarter = otherCapitalOutlaysExpensesPerQuarter;
    }

    public OtherCapitalOutlaysExpensesPerMonth getOtherCapitalOutlaysExpensesPerMonth() {
        return otherCapitalOutlaysExpensesPerMonth;
    }

    public void setOtherCapitalOutlaysExpensesPerMonth(OtherCapitalOutlaysExpensesPerMonth otherCapitalOutlaysExpensesPerMonth) {
        this.otherCapitalOutlaysExpensesPerMonth = otherCapitalOutlaysExpensesPerMonth;
    }

    public OtherCapitalOutlaysIncomePerQuarter getOtherCapitalOutlaysIncomePerQuarter() {
        return otherCapitalOutlaysIncomePerQuarter;
    }

    public void setOtherCapitalOutlaysIncomePerQuarter(OtherCapitalOutlaysIncomePerQuarter otherCapitalOutlaysIncomePerQuarter) {
        this.otherCapitalOutlaysIncomePerQuarter = otherCapitalOutlaysIncomePerQuarter;
    }

    public OtherCapitalOutlaysIncomePerMonth getOtherCapitalOutlaysIncomePerMonth() {
        return otherCapitalOutlaysIncomePerMonth;
    }

    public void setOtherCapitalOutlaysIncomePerMonth(OtherCapitalOutlaysIncomePerMonth otherCapitalOutlaysIncomePerMonth) {
        this.otherCapitalOutlaysIncomePerMonth = otherCapitalOutlaysIncomePerMonth;
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
