package mainpackage.entities.incomefinancestatistics;

import mainpackage.entities.expensesfinancestatistics.TotalExpensesPerMonth;
import mainpackage.entities.expensesfinancestatistics.TotalExpensesPerQuarter;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

//@Entity
public class IncomeFinanceStatistics {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerQuarter_id")
    private TotalIncomePerQuarter totalIncomePerQuarter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomePerMonth_id")
    private TotalIncomePerMonth totalIncomePerMonth;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private double totalIncomePerLastYear;

    private double currentIncomePerLastYear;

    private double charityIncomePerLastYear;

    private double healthIncomePerLastYear;

    private double kidsandpatsIncomePerLastYear;

    private double othercapoutlaysIncomePerLastYear;

    private double recreationIncomePerLastYear;

    private double reserveIncomePerLastYear;

    public IncomeFinanceStatistics() {
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

    public TotalIncomePerQuarter getTotalIncomePerQuarter() {
        return totalIncomePerQuarter;
    }

    public void setTotalIncomePerQuarter(TotalIncomePerQuarter totalIncomePerQuarter) {
        this.totalIncomePerQuarter = totalIncomePerQuarter;
    }

    public TotalIncomePerMonth getTotalIncomePerMonth() {
        return totalIncomePerMonth;
    }

    public void setTotalIncomePerMonth(TotalIncomePerMonth totalIncomePerMonth) {
        this.totalIncomePerMonth = totalIncomePerMonth;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalIncomePerLastYear() {
        return totalIncomePerLastYear;
    }

    public void setTotalIncomePerLastYear(double totalIncomePerLastYear) {
        this.totalIncomePerLastYear = totalIncomePerLastYear;
    }

    public double getCurrentIncomePerLastYear() {
        return currentIncomePerLastYear;
    }

    public void setCurrentIncomePerLastYear(double currentIncomePerLastYear) {
        this.currentIncomePerLastYear = currentIncomePerLastYear;
    }

    public double getCharityIncomePerLastYear() {
        return charityIncomePerLastYear;
    }

    public void setCharityIncomePerLastYear(double charityIncomePerLastYear) {
        this.charityIncomePerLastYear = charityIncomePerLastYear;
    }

    public double getHealthIncomePerLastYear() {
        return healthIncomePerLastYear;
    }

    public void setHealthIncomePerLastYear(double healthIncomePerLastYear) {
        this.healthIncomePerLastYear = healthIncomePerLastYear;
    }

    public double getKidsandpatsIncomePerLastYear() {
        return kidsandpatsIncomePerLastYear;
    }

    public void setKidsandpatsIncomePerLastYear(double kidsandpatsIncomePerLastYear) {
        this.kidsandpatsIncomePerLastYear = kidsandpatsIncomePerLastYear;
    }

    public double getOthercapoutlaysIncomePerLastYear() {
        return othercapoutlaysIncomePerLastYear;
    }

    public void setOthercapoutlaysIncomePerLastYear(double othercapoutlaysIncomePerLastYear) {
        this.othercapoutlaysIncomePerLastYear = othercapoutlaysIncomePerLastYear;
    }

    public double getRecreationIncomePerLastYear() {
        return recreationIncomePerLastYear;
    }

    public void setRecreationIncomePerLastYear(double recreationIncomePerLastYear) {
        this.recreationIncomePerLastYear = recreationIncomePerLastYear;
    }

    public double getReserveIncomePerLastYear() {
        return reserveIncomePerLastYear;
    }

    public void setReserveIncomePerLastYear(double reserveIncomePerLastYear) {
        this.reserveIncomePerLastYear = reserveIncomePerLastYear;
    }

}
