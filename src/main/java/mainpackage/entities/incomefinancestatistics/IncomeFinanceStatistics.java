package mainpackage.entities.incomefinancestatistics;

import mainpackage.entities.ItemOfExpenses;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
public class IncomeFinanceStatistics {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private Map<Integer, Double> totalExpensesPerMonth;

    private Map<Integer, Double> totalExpensesPerQuarter;

    private double totalExpensesPerLastYear;

    private Map<Integer, Double> currentExpensesPerMonth;

    private Map<Integer, Double> currentExpensesPerQuarter;

    private double currentExpensesPerLastYear;

    private Map<ItemOfExpenses, Map<Integer, Double>> expensesPerMonth;

    private Map<ItemOfExpenses, Map<Integer, Double>> expensesPerQuarter;

    private Map<ItemOfExpenses, Double> expensesPerLastYear;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<Integer, Double> getTotalExpensesPerMonth() {
        return totalExpensesPerMonth;
    }

    public void setTotalExpensesPerMonth(Map<Integer, Double> totalExpensesPerMonth) {
        this.totalExpensesPerMonth = totalExpensesPerMonth;
    }

    public Map<Integer, Double> getTotalExpensesPerQuarter() {
        return totalExpensesPerQuarter;
    }

    public void setTotalExpensesPerQuarter(Map<Integer, Double> totalExpensesPerQuarter) {
        this.totalExpensesPerQuarter = totalExpensesPerQuarter;
    }

    public double getTotalExpensesPerLastYear() {
        return totalExpensesPerLastYear;
    }

    public void setTotalExpensesPerLastYear(double totalExpensesPerLastYear) {
        this.totalExpensesPerLastYear = totalExpensesPerLastYear;
    }

    public Map<Integer, Double> getCurrentExpensesPerMonth() {
        return currentExpensesPerMonth;
    }

    public void setCurrentExpensesPerMonth(Map<Integer, Double> currentExpensesPerMonth) {
        this.currentExpensesPerMonth = currentExpensesPerMonth;
    }

    public Map<Integer, Double> getCurrentExpensesPerQuarter() {
        return currentExpensesPerQuarter;
    }

    public void setCurrentExpensesPerQuarter(Map<Integer, Double> currentExpensesPerQuarter) {
        this.currentExpensesPerQuarter = currentExpensesPerQuarter;
    }

    public double getCurrentExpensesPerLastYear() {
        return currentExpensesPerLastYear;
    }

    public void setCurrentExpensesPerLastYear(double currentExpensesPerLastYear) {
        this.currentExpensesPerLastYear = currentExpensesPerLastYear;
    }

    public Map<ItemOfExpenses, Map<Integer, Double>> getExpensesPerMonth() {
        return expensesPerMonth;
    }

    public void setExpensesPerMonth(Map<ItemOfExpenses, Map<Integer, Double>> expensesPerMonth) {
        this.expensesPerMonth = expensesPerMonth;
    }

    public Map<ItemOfExpenses, Map<Integer, Double>> getExpensesPerQuarter() {
        return expensesPerQuarter;
    }

    public void setExpensesPerQuarter(Map<ItemOfExpenses, Map<Integer, Double>> expensesPerQuarter) {
        this.expensesPerQuarter = expensesPerQuarter;
    }

    public Map<ItemOfExpenses, Double> getExpensesPerLastYear() {
        return expensesPerLastYear;
    }

    public void setExpensesPerLastYear(Map<ItemOfExpenses, Double> expensesPerLastYear) {
        this.expensesPerLastYear = expensesPerLastYear;
    }
}
