package mainpackage.entities.incomefinancestatistics;

import mainpackage.entities.expensesfinancestatistics.ExpensesFinanceStatistics;

import javax.persistence.*;

@Entity
public class TotalIncomePerQuarter {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "totalExpensesPerQuarter")
    private IncomeFinanceStatistics incomeFinanceStatistics;

    private double totalIncome1QuaterAgo;

    private double totalIncome2QuaterAgo;

    private double totalIncome3QuaterAgo;

    private double totalIncome4QuaterAgo;

    public TotalIncomePerQuarter() {
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

    public double getTotalExpenses1QuaterAgo() {
        return totalExpenses1QuaterAgo;
    }

    public void setTotalExpenses1QuaterAgo(double totalExpenses1QuaterAgo) {
        this.totalExpenses1QuaterAgo = totalExpenses1QuaterAgo;
    }

    public double getTotalExpenses2QuaterAgo() {
        return totalExpenses2QuaterAgo;
    }

    public void setTotalExpenses2QuaterAgo(double totalExpenses2QuaterAgo) {
        this.totalExpenses2QuaterAgo = totalExpenses2QuaterAgo;
    }

    public double getTotalExpenses3QuaterAgo() {
        return totalExpenses3QuaterAgo;
    }

    public void setTotalExpenses3QuaterAgo(double totalExpenses3QuaterAgo) {
        this.totalExpenses3QuaterAgo = totalExpenses3QuaterAgo;
    }

    public double getTotalExpenses4QuaterAgo() {
        return totalExpenses4QuaterAgo;
    }

    public void setTotalExpenses4QuaterAgo(double totalExpenses4QuaterAgo) {
        this.totalExpenses4QuaterAgo = totalExpenses4QuaterAgo;
    }


}
