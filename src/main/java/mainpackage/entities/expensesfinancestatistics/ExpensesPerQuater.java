package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.ItemOfExpenses;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class ExpensesPerQuater {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    private List<ItemOfExpenses> expensesByTypes = new ArrayList<>();

    private double totalExpenses1QuaterAgo;

    private double totalExpenses2QuaterAgo;

    private double totalExpenses3QuaterAgo;

    private double totalExpenses4QuaterAgo;

    public ExpensesPerQuater() {
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

    public List<ItemOfExpenses> getExpensesByTypes() {
        return expensesByTypes;
    }

    public void setExpensesByTypes(List<ItemOfExpenses> expensesByTypes) {
        this.expensesByTypes = expensesByTypes;
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
