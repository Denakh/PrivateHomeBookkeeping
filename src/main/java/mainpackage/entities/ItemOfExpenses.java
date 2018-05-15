package mainpackage.entities;

import mainpackage.entities.expensesfinancestatistics.ExpensesPerMonth;
import mainpackage.entities.expensesfinancestatistics.ExpensesPerQuater;

public class ItemOfExpenses {

    protected String expenseType;

    protected ExpensesPerMonth expensesPerMonth;

    protected ExpensesPerQuater expensesPerQuater;

    public ItemOfExpenses() {
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public ExpensesPerMonth getExpensesPerMonth() {
        return expensesPerMonth;
    }

    public void setExpensesPerMonth(ExpensesPerMonth expensesPerMonth) {
        this.expensesPerMonth = expensesPerMonth;
    }

    public ExpensesPerQuater getExpensesPerQuater() {
        return expensesPerQuater;
    }

    public void setExpensesPerQuater(ExpensesPerQuater expensesPerQuater) {
        this.expensesPerQuater = expensesPerQuater;
    }
}
