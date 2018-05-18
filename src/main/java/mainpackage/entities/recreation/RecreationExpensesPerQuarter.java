package mainpackage.entities.recreation;

import mainpackage.entities.charity.Charity;
import mainpackage.entities.recreation.Recreation;

import javax.persistence.*;

@Entity
public class RecreationExpensesPerQuarter {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "recreationExpensesPerQuarter")
    private Recreation recreation;

    private double totalExpenses1QuaterAgo;

    private double totalExpenses2QuaterAgo;

    private double totalExpenses3QuaterAgo;

    private double totalExpenses4QuaterAgo;

    public RecreationExpensesPerQuarter() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Recreation getRecreation() {
        return recreation;
    }

    public void setRecreation(Recreation recreation) {
        this.recreation = recreation;
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
