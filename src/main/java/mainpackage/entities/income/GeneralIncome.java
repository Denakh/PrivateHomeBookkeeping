package mainpackage.entities.income;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GeneralIncome {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    private double amount;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "generalIncome")
    private Income income;

    private byte monthNumber;

    private double accumulation;

    private double excessForAllocation;

    public GeneralIncome() {
    }

    public GeneralIncome(Date date, byte monthNumber) {
        this.date = date;
        this.monthNumber = monthNumber;
    }

    public GeneralIncome(byte monthNumber, double accumulation, double excessForAllocation) {
        this.monthNumber = monthNumber;
        this.accumulation = accumulation;
        this.excessForAllocation = excessForAllocation;
    }

    public GeneralIncome(double amount, Date date, byte monthNumber, double accumulation, double excessForAllocation) {
        this.amount = amount;
        this.date = date;
        this.monthNumber = monthNumber;
        this.accumulation = accumulation;
        this.excessForAllocation = excessForAllocation;
    }

    public GeneralIncome(CustomUser user, double amount, Date date, byte monthNumber, double accumulation, double excessForAllocation) {
        this.user = user;
        this.amount = amount;
        this.date = date;
        this.monthNumber = monthNumber;
        this.accumulation = accumulation;
        this.excessForAllocation = excessForAllocation;
    }

    public GeneralIncome(CustomUser user, double amount, Date date, Income income, byte monthNumber, double accumulation, double excessForAllocation) {
        this.user = user;
        this.amount = amount;
        this.date = date;
        this.income = income;
        this.monthNumber = monthNumber;
        this.accumulation = accumulation;
        this.excessForAllocation = excessForAllocation;
    }

    public long getId() {
        return id;
    }

    public CustomUser getUser() {
        return user;
    }

    public void setUser(CustomUser user) {
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
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

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public byte getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(byte monthNumber) {
        this.monthNumber = monthNumber;
    }

    public double getAccumulation() {
        return accumulation;
    }

    public void setAccumulation(double accumulation) {
        this.accumulation = accumulation;
    }

    public double getExcessForAllocation() {
        return excessForAllocation;
    }

    public void setExcessForAllocation(double excessForAllocation) {
        this.excessForAllocation = excessForAllocation;
    }

}
