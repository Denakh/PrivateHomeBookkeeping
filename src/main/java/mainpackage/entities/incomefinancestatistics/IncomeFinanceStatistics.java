package mainpackage.entities.incomefinancestatistics;

import mainpackage.entities.ItemOfExpenses;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Map;

public class IncomeFinanceStatistics {

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private Map<Integer,Double> totalExpensesPerMonth;

    private Map<Integer,Double> totalExpensesPerQuarter;

    private double totalExpensesPerLastYear;

    private Map<Integer,Double> currentExpensesPerMonth;

    private Map<Integer,Double> currentExpensesPerQuarter;

    private double currentExpensesPerLastYear;

    private Map<ItemOfExpenses,Map<Integer,Double>> expensesPerMonth;

    private Map<ItemOfExpenses,Map<Integer,Double>> expensesPerQuarter;

    private Map<ItemOfExpenses,Double> expensesPerLastYear;}
