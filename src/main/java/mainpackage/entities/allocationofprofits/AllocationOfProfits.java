package mainpackage.entities.allocationofprofits;

import mainpackage.entities.ExpenseType;
import mainpackage.entities.ItemOfExpenses;
import mainpackage.entities.users.CustomUser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AllocationOfProfits {
    @Id
    @GeneratedValue
    private long id;

    private CustomUser user;

    private ItemOfExpenses purpose;

    private double percent;

}
