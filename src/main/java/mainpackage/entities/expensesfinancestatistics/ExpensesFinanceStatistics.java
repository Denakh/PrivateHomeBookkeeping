package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.ItemOfExpenses;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Map;

public class ExpensesFinanceStatistics {

    //CHARITY, HEALTH, KIDSANDPATS, OTHERCAPOUTLAYS, RECREATION, RESERVE


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

}
