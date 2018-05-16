package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.ItemOfExpenses;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

//@Entity
public class ExpensesFinanceStatistics {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private double totalExpensesPerLastYear;

    private double currentExpensesPerLastYear;

    private double charityExpensesPerLastYear;

    private double healthExpensesPerLastYear;

    private double kidsandpatsExpensesPerLastYear;

    private double othercapoutlaysExpensesPerLastYear;

    private double recreationExpensesPerLastYear;

    private double reserveExpensesPerLastYear;

    public ExpensesFinanceStatistics() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalExpensesPerLastYear() {
        return totalExpensesPerLastYear;
    }

    public void setTotalExpensesPerLastYear(double totalExpensesPerLastYear) {
        this.totalExpensesPerLastYear = totalExpensesPerLastYear;
    }

    public double getCurrentExpensesPerLastYear() {
        return currentExpensesPerLastYear;
    }

    public void setCurrentExpensesPerLastYear(double currentExpensesPerLastYear) {
        this.currentExpensesPerLastYear = currentExpensesPerLastYear;
    }

    public double getCharityExpensesPerLastYear() {
        return charityExpensesPerLastYear;
    }

    public void setCharityExpensesPerLastYear(double charityExpensesPerLastYear) {
        this.charityExpensesPerLastYear = charityExpensesPerLastYear;
    }

    public double getHealthExpensesPerLastYear() {
        return healthExpensesPerLastYear;
    }

    public void setHealthExpensesPerLastYear(double healthExpensesPerLastYear) {
        this.healthExpensesPerLastYear = healthExpensesPerLastYear;
    }

    public double getKidsandpatsExpensesPerLastYear() {
        return kidsandpatsExpensesPerLastYear;
    }

    public void setKidsandpatsExpensesPerLastYear(double kidsandpatsExpensesPerLastYear) {
        this.kidsandpatsExpensesPerLastYear = kidsandpatsExpensesPerLastYear;
    }

    public double getOthercapoutlaysExpensesPerLastYear() {
        return othercapoutlaysExpensesPerLastYear;
    }

    public void setOthercapoutlaysExpensesPerLastYear(double othercapoutlaysExpensesPerLastYear) {
        this.othercapoutlaysExpensesPerLastYear = othercapoutlaysExpensesPerLastYear;
    }

    public double getRecreationExpensesPerLastYear() {
        return recreationExpensesPerLastYear;
    }

    public void setRecreationExpensesPerLastYear(double recreationExpensesPerLastYear) {
        this.recreationExpensesPerLastYear = recreationExpensesPerLastYear;
    }

    public double getReserveExpensesPerLastYear() {
        return reserveExpensesPerLastYear;
    }

    public void setReserveExpensesPerLastYear(double reserveExpensesPerLastYear) {
        this.reserveExpensesPerLastYear = reserveExpensesPerLastYear;
    }


}
