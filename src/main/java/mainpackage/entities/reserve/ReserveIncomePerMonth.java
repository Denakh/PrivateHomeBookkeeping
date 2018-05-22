package mainpackage.entities.reserve;

import mainpackage.entities.health.Health;

import javax.persistence.*;

@Entity
public class ReserveIncomePerMonth {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "reserveIncomePerMonth")
    private Reserve reserve;

    private double totalIncome1MonthAgo;

    private double totalIncome2MonthAgo;

    private double totalIncome3MonthAgo;

    private double totalIncome4MonthAgo;

    private double totalIncome5MonthAgo;

    private double totalIncome6MonthAgo;

    private double totalIncome7MonthAgo;

    private double totalIncome8MonthAgo;

    private double totalIncome9MonthAgo;

    private double totalIncome10MonthAgo;

    private double totalIncome11MonthAgo;

    private double totalIncome12MonthAgo;

    public ReserveIncomePerMonth() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Reserve getReserve() {
        return reserve;
    }

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }

    public double getTotalIncome1MonthAgo() {
        return totalIncome1MonthAgo;
    }

    public void setTotalIncome1MonthAgo(double totalIncome1MonthAgo) {
        this.totalIncome1MonthAgo = totalIncome1MonthAgo;
    }

    public double getTotalIncome2MonthAgo() {
        return totalIncome2MonthAgo;
    }

    public void setTotalIncome2MonthAgo(double totalIncome2MonthAgo) {
        this.totalIncome2MonthAgo = totalIncome2MonthAgo;
    }

    public double getTotalIncome3MonthAgo() {
        return totalIncome3MonthAgo;
    }

    public void setTotalIncome3MonthAgo(double totalIncome3MonthAgo) {
        this.totalIncome3MonthAgo = totalIncome3MonthAgo;
    }

    public double getTotalIncome4MonthAgo() {
        return totalIncome4MonthAgo;
    }

    public void setTotalIncome4MonthAgo(double totalIncome4MonthAgo) {
        this.totalIncome4MonthAgo = totalIncome4MonthAgo;
    }

    public double getTotalIncome5MonthAgo() {
        return totalIncome5MonthAgo;
    }

    public void setTotalIncome5MonthAgo(double totalIncome5MonthAgo) {
        this.totalIncome5MonthAgo = totalIncome5MonthAgo;
    }

    public double getTotalIncome6MonthAgo() {
        return totalIncome6MonthAgo;
    }

    public void setTotalIncome6MonthAgo(double totalIncome6MonthAgo) {
        this.totalIncome6MonthAgo = totalIncome6MonthAgo;
    }

    public double getTotalIncome7MonthAgo() {
        return totalIncome7MonthAgo;
    }

    public void setTotalIncome7MonthAgo(double totalIncome7MonthAgo) {
        this.totalIncome7MonthAgo = totalIncome7MonthAgo;
    }

    public double getTotalIncome8MonthAgo() {
        return totalIncome8MonthAgo;
    }

    public void setTotalIncome8MonthAgo(double totalIncome8MonthAgo) {
        this.totalIncome8MonthAgo = totalIncome8MonthAgo;
    }

    public double getTotalIncome9MonthAgo() {
        return totalIncome9MonthAgo;
    }

    public void setTotalIncome9MonthAgo(double totalIncome9MonthAgo) {
        this.totalIncome9MonthAgo = totalIncome9MonthAgo;
    }

    public double getTotalIncome10MonthAgo() {
        return totalIncome10MonthAgo;
    }

    public void setTotalIncome10MonthAgo(double totalIncome10MonthAgo) {
        this.totalIncome10MonthAgo = totalIncome10MonthAgo;
    }

    public double getTotalIncome11MonthAgo() {
        return totalIncome11MonthAgo;
    }

    public void setTotalIncome11MonthAgo(double totalIncome11MonthAgo) {
        this.totalIncome11MonthAgo = totalIncome11MonthAgo;
    }

    public double getTotalIncome12MonthAgo() {
        return totalIncome12MonthAgo;
    }

    public void setTotalIncome12MonthAgo(double totalIncome12MonthAgo) {
        this.totalIncome12MonthAgo = totalIncome12MonthAgo;
    }

}
