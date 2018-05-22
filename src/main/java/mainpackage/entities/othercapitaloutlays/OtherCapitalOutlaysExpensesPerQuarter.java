package mainpackage.entities.othercapitaloutlays;

import mainpackage.entities.charity.Charity;
import mainpackage.entities.othercapitaloutlays.OtherCapitalOutlays;

import javax.persistence.*;

@Entity
public class OtherCapitalOutlaysExpensesPerQuarter {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "otherCapitalOutlaysExpensesPerQuarter")
    private OtherCapitalOutlays otherCapitalOutlays;

    private double totalExpenses1QuaterAgo;

    private double totalExpenses2QuaterAgo;

    private double totalExpenses3QuaterAgo;

    private double totalExpenses4QuaterAgo;

    public OtherCapitalOutlaysExpensesPerQuarter() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OtherCapitalOutlays getOtherCapitalOutlays() {
        return otherCapitalOutlays;
    }

    public void setOtherCapitalOutlays(OtherCapitalOutlays otherCapitalOutlays) {
        this.otherCapitalOutlays = otherCapitalOutlays;
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