package mainpackage.entities.kidsandpets;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class KidsAndPets {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerQuarter_id")
    private KidsAndPetsExpensesPerQuarter kidsAndPetsExpensesPerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expensesPerMonth_id")
    private KidsAndPetsExpensesPerMonth kidsAndPetsExpensesPerMonth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerQuarter_id")
    private KidsAndPetsIncomePerQuarter kidsAndPetsIncomePerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerMonth_id")
    private KidsAndPetsIncomePerMonth kidsAndPetsIncomePerMonth;

    private double amountChange;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private double amount;

    public KidsAndPets() {
    }

    public KidsAndPets(CustomUser user, double amountChange, Date date, String description, double amount) {
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

    public KidsAndPetsExpensesPerQuarter getKidsAndPetsExpensesPerQuarter() {
        return kidsAndPetsExpensesPerQuarter;
    }

    public void setKidsAndPetsExpensesPerQuarter(KidsAndPetsExpensesPerQuarter kidsAndPetsExpensesPerQuarter) {
        this.kidsAndPetsExpensesPerQuarter = kidsAndPetsExpensesPerQuarter;
    }

    public KidsAndPetsExpensesPerMonth getKidsAndPetsExpensesPerMonth() {
        return kidsAndPetsExpensesPerMonth;
    }

    public void setKidsAndPetsExpensesPerMonth(KidsAndPetsExpensesPerMonth kidsAndPetsExpensesPerMonth) {
        this.kidsAndPetsExpensesPerMonth = kidsAndPetsExpensesPerMonth;
    }

    public KidsAndPetsIncomePerQuarter getKidsAndPetsIncomePerQuarter() {
        return kidsAndPetsIncomePerQuarter;
    }

    public void setKidsAndPetsIncomePerQuarter(KidsAndPetsIncomePerQuarter kidsAndPetsIncomePerQuarter) {
        this.kidsAndPetsIncomePerQuarter = kidsAndPetsIncomePerQuarter;
    }

    public KidsAndPetsIncomePerMonth getKidsAndPetsIncomePerMonth() {
        return kidsAndPetsIncomePerMonth;
    }

    public void setKidsAndPetsIncomePerMonth(KidsAndPetsIncomePerMonth kidsAndPetsIncomePerMonth) {
        this.kidsAndPetsIncomePerMonth = kidsAndPetsIncomePerMonth;
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
