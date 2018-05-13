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
}
