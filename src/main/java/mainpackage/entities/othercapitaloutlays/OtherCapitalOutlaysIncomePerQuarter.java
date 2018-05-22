package mainpackage.entities.othercapitaloutlays;

import mainpackage.entities.health.Health;

import javax.persistence.*;

@Entity
public class OtherCapitalOutlaysIncomePerQuarter {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "otherCapitalOutlaysIncomePerQuarter")
    private OtherCapitalOutlays otherCapitalOutlays;

    private double totalIncome1QuaterAgo;

    private double totalIncome2QuaterAgo;

    private double totalIncome3QuaterAgo;

    private double totalIncome4QuaterAgo;

    public OtherCapitalOutlaysIncomePerQuarter() {
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

    public double getTotalIncome1QuaterAgo() {
        return totalIncome1QuaterAgo;
    }

    public void setTotalIncome1QuaterAgo(double totalIncome1QuaterAgo) {
        this.totalIncome1QuaterAgo = totalIncome1QuaterAgo;
    }

    public double getTotalIncome2QuaterAgo() {
        return totalIncome2QuaterAgo;
    }

    public void setTotalIncome2QuaterAgo(double totalIncome2QuaterAgo) {
        this.totalIncome2QuaterAgo = totalIncome2QuaterAgo;
    }

    public double getTotalIncome3QuaterAgo() {
        return totalIncome3QuaterAgo;
    }

    public void setTotalIncome3QuaterAgo(double totalIncome3QuaterAgo) {
        this.totalIncome3QuaterAgo = totalIncome3QuaterAgo;
    }

    public double getTotalIncome4QuaterAgo() {
        return totalIncome4QuaterAgo;
    }

    public void setTotalIncome4QuaterAgo(double totalIncome4QuaterAgo) {
        this.totalIncome4QuaterAgo = totalIncome4QuaterAgo;
    }
}