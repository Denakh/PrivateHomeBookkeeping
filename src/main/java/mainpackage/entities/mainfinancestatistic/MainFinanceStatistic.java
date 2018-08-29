package mainpackage.entities.mainfinancestatistic;

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
    private int year;
    private double totalIncome;
    private double totalExpenses;
    private double expToIncRatio;
    private double currentExpenses;
    private double curExpensesCoverByIncome;
    private double passiveDebts;
    private double overallBalanceWD;
    private double passDebtsToOBRatio;
    private double curExpFactStandDif;

    @Enumerated(EnumType.STRING)
    private FinancialCondition fcByCurExpCover;
    @Enumerated(EnumType.STRING)
    private FinancialCondition fcByDebtsToOBRatio;
    @Enumerated(EnumType.STRING)
    private FinancialCondition fcResult;

    private byte monthLast;
    private int yearLast;

    public MainFinanceStatistic() {
    }

    public MainFinanceStatistic(byte month, int year, double totalIncome, double totalExpenses, double expToIncRatio,
                                double currentExpenses, double curExpensesCoverByIncome, double passiveDebts,
                                double overallBalanceWD, double passDebtsToOBRatio, double curExpFactStandDif,
                                FinancialCondition fcByCurExpCover, FinancialCondition fcByDebtsToOBRatio, byte monthLast, int yearLast) {
        this.month = month;
        this.year = year;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.expToIncRatio = expToIncRatio;
        this.currentExpenses = currentExpenses;
        this.curExpensesCoverByIncome = curExpensesCoverByIncome;
        this.passiveDebts = passiveDebts;
        this.overallBalanceWD = overallBalanceWD;
        this.passDebtsToOBRatio = passDebtsToOBRatio;
        this.curExpFactStandDif = curExpFactStandDif;
        this.fcByCurExpCover = fcByCurExpCover;
        this.fcByDebtsToOBRatio = fcByDebtsToOBRatio;
        this.monthLast = monthLast;
        this.yearLast = yearLast;
    }

    public MainFinanceStatistic(CustomUser user, byte month, int year, double totalIncome, double totalExpenses, double expToIncRatio, double currentExpenses, double curExpensesCoverByIncome, double passiveDebts, double overallBalanceWD, double passDebtsToOBRatio, double curExpFactStandDif, FinancialCondition fcByCurExpCover, FinancialCondition fcByDebtsToOBRatio, FinancialCondition fcResult, byte monthLast, int yearLast) {
        this.user = user;
        this.month = month;
        this.year = year;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.expToIncRatio = expToIncRatio;
        this.currentExpenses = currentExpenses;
        this.curExpensesCoverByIncome = curExpensesCoverByIncome;
        this.passiveDebts = passiveDebts;
        this.overallBalanceWD = overallBalanceWD;
        this.passDebtsToOBRatio = passDebtsToOBRatio;
        this.curExpFactStandDif = curExpFactStandDif;
        this.fcByCurExpCover = fcByCurExpCover;
        this.fcByDebtsToOBRatio = fcByDebtsToOBRatio;
        this.fcResult = fcResult;
        this.monthLast = monthLast;
        this.yearLast = yearLast;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public double getCurExpFactStandDif() {
        return curExpFactStandDif;
    }

    public void setCurExpFactStandDif(double curExpFactStandDif) {
        this.curExpFactStandDif = curExpFactStandDif;
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

    public FinancialCondition getFcResult() {
        return fcResult;
    }

    public void setFcResult(FinancialCondition fcResult) {
        this.fcResult = fcResult;
    }

    public byte getMonthLast() {
        return monthLast;
    }

    public void setMonthLast(byte monthLast) {
        this.monthLast = monthLast;
    }

    public int getYearLast() {
        return yearLast;
    }

    public void setYearLast(int yearLast) {
        this.yearLast = yearLast;
    }
}
