package mainpackage.entities.expensesfinancestatistics;

import javax.persistence.*;

@Entity
public class TotalExpensesPerMonth {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "totalExpensesPerMonth")
    private ExpensesFinanceStatistics expensesFinanceStatistics;

    private double totalExpenses1MonthAgo;

    private double totalExpenses2MonthAgo;

    private double totalExpenses3MonthAgo;

    private double totalExpenses4MonthAgo;

    private double totalExpenses5MonthAgo;

    private double totalExpenses6MonthAgo;

    private double totalExpenses7MonthAgo;

    private double totalExpenses8MonthAgo;

    private double totalExpenses9MonthAgo;

    private double totalExpenses10MonthAgo;

    private double totalExpenses11MonthAgo;

    private double totalExpenses12MonthAgo;

    public TotalExpensesPerMonth() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ExpensesFinanceStatistics getExpensesFinanceStatistics() {
        return expensesFinanceStatistics;
    }

    public void setExpensesFinanceStatistics(ExpensesFinanceStatistics expensesFinanceStatistics) {
        this.expensesFinanceStatistics = expensesFinanceStatistics;
    }

    public double getTotalExpenses1MonthAgo() {
        return totalExpenses1MonthAgo;
    }

    public void setTotalExpenses1MonthAgo(double totalExpenses1MonthAgo) {
        this.totalExpenses1MonthAgo = totalExpenses1MonthAgo;
    }

    public double getTotalExpenses2MonthAgo() {
        return totalExpenses2MonthAgo;
    }

    public void setTotalExpenses2MonthAgo(double totalExpenses2MonthAgo) {
        this.totalExpenses2MonthAgo = totalExpenses2MonthAgo;
    }

    public double getTotalExpenses3MonthAgo() {
        return totalExpenses3MonthAgo;
    }

    public void setTotalExpenses3MonthAgo(double totalExpenses3MonthAgo) {
        this.totalExpenses3MonthAgo = totalExpenses3MonthAgo;
    }

    public double getTotalExpenses4MonthAgo() {
        return totalExpenses4MonthAgo;
    }

    public void setTotalExpenses4MonthAgo(double totalExpenses4MonthAgo) {
        this.totalExpenses4MonthAgo = totalExpenses4MonthAgo;
    }

    public double getTotalExpenses5MonthAgo() {
        return totalExpenses5MonthAgo;
    }

    public void setTotalExpenses5MonthAgo(double totalExpenses5MonthAgo) {
        this.totalExpenses5MonthAgo = totalExpenses5MonthAgo;
    }

    public double getTotalExpenses6MonthAgo() {
        return totalExpenses6MonthAgo;
    }

    public void setTotalExpenses6MonthAgo(double totalExpenses6MonthAgo) {
        this.totalExpenses6MonthAgo = totalExpenses6MonthAgo;
    }

    public double getTotalExpenses7MonthAgo() {
        return totalExpenses7MonthAgo;
    }

    public void setTotalExpenses7MonthAgo(double totalExpenses7MonthAgo) {
        this.totalExpenses7MonthAgo = totalExpenses7MonthAgo;
    }

    public double getTotalExpenses8MonthAgo() {
        return totalExpenses8MonthAgo;
    }

    public void setTotalExpenses8MonthAgo(double totalExpenses8MonthAgo) {
        this.totalExpenses8MonthAgo = totalExpenses8MonthAgo;
    }

    public double getTotalExpenses9MonthAgo() {
        return totalExpenses9MonthAgo;
    }

    public void setTotalExpenses9MonthAgo(double totalExpenses9MonthAgo) {
        this.totalExpenses9MonthAgo = totalExpenses9MonthAgo;
    }

    public double getTotalExpenses10MonthAgo() {
        return totalExpenses10MonthAgo;
    }

    public void setTotalExpenses10MonthAgo(double totalExpenses10MonthAgo) {
        this.totalExpenses10MonthAgo = totalExpenses10MonthAgo;
    }

    public double getTotalExpenses11MonthAgo() {
        return totalExpenses11MonthAgo;
    }

    public void setTotalExpenses11MonthAgo(double totalExpenses11MonthAgo) {
        this.totalExpenses11MonthAgo = totalExpenses11MonthAgo;
    }

    public double getTotalExpenses12MonthAgo() {
        return totalExpenses12MonthAgo;
    }

    public void setTotalExpenses12MonthAgo(double totalExpenses12MonthAgo) {
        this.totalExpenses12MonthAgo = totalExpenses12MonthAgo;
    }

}
