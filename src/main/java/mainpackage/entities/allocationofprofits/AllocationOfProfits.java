package mainpackage.entities.allocationofprofits;

import mainpackage.entities.ExpenseType;
import mainpackage.entities.ItemOfExpenses;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;

@Entity
public class AllocationOfProfits {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    private ItemOfExpenses purpose;

    private double percent;

}
