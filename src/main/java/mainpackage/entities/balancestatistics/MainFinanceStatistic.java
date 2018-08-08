package mainpackage.entities.balancestatistics;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;

@Entity
public class MainFinanceStatistic {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    private byte month;
    private double totalIncome;
    private double totalExpenses;
    private double expToIncRatio;
    private double currentExpenses;
    private double curExpensesCoverByIncome;
    private double passiveDebts;
    private double overallBalanceWD;
    private double passDebtsToOBRatio;

    @Enumerated(EnumType.STRING)
    private FinancialCondition fcByCurExpCover;
    @Enumerated(EnumType.STRING)
    private FinancialCondition fcByDebtsToOBRatio;

    public MainFinanceStatistic() {
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

    public byte getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getExpToIncRatio() {
        return expToIncRatio;
    }

    public void setExpToIncRatio(double expToIncRatio) {
        this.expToIncRatio = expToIncRatio;
    }

    public double getCurrentExpenses() {
        return currentExpenses;
    }

    public void setCurrentExpenses(double currentExpenses) {
        this.currentExpenses = currentExpenses;
    }

    public double getCurExpensesCoverByIncome() {
        return curExpensesCoverByIncome;
    }

    public void setCurExpensesCoverByIncome(double curExpensesCoverByIncome) {
        this.curExpensesCoverByIncome = curExpensesCoverByIncome;
    }

    public double getPassiveDebts() {
        return passiveDebts;
    }

    public void setPassiveDebts(double passiveDebts) {
        this.passiveDebts = passiveDebts;
    }

    public double getOverallBalanceWD() {
        return overallBalanceWD;
    }

    public void setOverallBalanceWD(double overallBalanceWD) {
        this.overallBalanceWD = overallBalanceWD;
    }

    public double getPassDebtsToOBRatio() {
        return passDebtsToOBRatio;
    }

    public void setPassDebtsToOBRatio(double passDebtsToOBRatio) {
        this.passDebtsToOBRatio = passDebtsToOBRatio;
    }

    public FinancialCondition getFcByCurExpCover() {
        return fcByCurExpCover;
    }

    public void setFcByCurExpCover(FinancialCondition fcByCurExpCover) {
        this.fcByCurExpCover = fcByCurExpCover;
    }

    public FinancialCondition getFcByDebtsToOBRatio() {
        return fcByDebtsToOBRatio;
    }

    public void setFcByDebtsToOBRatio(FinancialCondition fcByDebtsToOBRatio) {
        this.fcByDebtsToOBRatio = fcByDebtsToOBRatio;
    }

}
