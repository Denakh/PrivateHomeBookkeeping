package mainpackage.entities.charity;

import javax.persistence.*;

@Entity
public class CharityIncomePerQuarter {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "charityIncomePerQuarter")
    private Charity charity;

    private double totalIncome1QuaterAgo;

    private double totalIncome2QuaterAgo;

    private double totalIncome3QuaterAgo;

    private double totalIncome4QuaterAgo;

    public CharityIncomePerQuarter() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Charity getCharity() {
        return charity;
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
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
