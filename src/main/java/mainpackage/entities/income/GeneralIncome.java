package mainpackage.entities.income;

import mainpackage.entities.kidsandpets.KidsAndPets;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GeneralIncome {

    @Id
    @GeneratedValue
    private long id;

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

    public GeneralIncome(double amount, Date date) {
        this.amount = amount;
        this.date = date;
        //this.monthNumber = monthNumber;
        //this.accumulation = accumulation;
        //this.excessForAllocation = excessForAllocation;
    }

    public GeneralIncome(double amount, Date date, Income income, byte monthNumber, double accumulation, double excessForAllocation) {
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
