package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.ItemOfExpenses;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
public class ExpensesFinanceStatistics {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

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
