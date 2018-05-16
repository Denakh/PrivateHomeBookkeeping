package mainpackage.entities.ballancestatistics;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BallanceStatistics {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    private Date period;

    private double currrentBalance;

    private double outlaysPerIncome;

    private double outlaysMinIncome;

    private double averageOPIlast3months;

    private double averageOPIlast6months;

    private double averageOPIlast12months;

    @Enumerated(EnumType.STRING)
    private FinancialConditionBal finConditionBal;

    public BallanceStatistics() {
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

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public double getCurrrentBalance() {
        return currrentBalance;
    }

    public void setCurrrentBalance(double currrentBalance) {
        this.currrentBalance = currrentBalance;
    }

    public double getOutlaysPerIncome() {
        return outlaysPerIncome;
    }

    public void setOutlaysPerIncome(double outlaysPerIncome) {
        this.outlaysPerIncome = outlaysPerIncome;
    }

    public double getOutlaysMinIncome() {
        return outlaysMinIncome;
    }

    public void setOutlaysMinIncome(double outlaysMinIncome) {
        this.outlaysMinIncome = outlaysMinIncome;
    }

    public double getAverageOPIlast3months() {
        return averageOPIlast3months;
    }

    public void setAverageOPIlast3months(double averageOPIlast3months) {
        this.averageOPIlast3months = averageOPIlast3months;
    }

    public double getAverageOPIlast6months() {
        return averageOPIlast6months;
    }

    public void setAverageOPIlast6months(double averageOPIlast6months) {
        this.averageOPIlast6months = averageOPIlast6months;
    }

    public double getAverageOPIlast12months() {
        return averageOPIlast12months;
    }

    public void setAverageOPIlast12months(double averageOPIlast12months) {
        this.averageOPIlast12months = averageOPIlast12months;
    }

    public FinancialConditionBal getFinConditionBal() {
        return finConditionBal;
    }

    public void setFinConditionBal(FinancialConditionBal finConditionBal) {
        this.finConditionBal = finConditionBal;
    }
}
