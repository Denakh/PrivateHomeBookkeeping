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

    //private ItemOfExpenses purpose;
    private String purpose;

    private double percent;

    public AllocationOfProfits() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomUser getUser() {
        return user;
    }

    public void setUser(CustomUser user) {
        this.user = user;
    }

    //public ItemOfExpenses getPurpose() {
    //    return purpose;
    //}

    //public void setPurpose(ItemOfExpenses purpose) {
    //    this.purpose = purpose;
    //}

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
