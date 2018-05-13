package mainpackage.entities.ballancestatistics;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BallanceStatistics {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    private Date period;

    private double currrentBalance;

    private double outlaysPerIncome;

    private double outlaysMinIncome;

    private double averageOPIlast3months;

    private double averageOPIlast6months;

    private double averageOPIlast12months;

    @Enumerated(EnumType.STRING)
    private FinancialConditionBal finConditionBal;


}
