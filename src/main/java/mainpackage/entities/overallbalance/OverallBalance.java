package mainpackage.entities.overallbalance;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OverallBalance {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private double balanceLiq;
    private double balanceWithDep;
    private double differenceLiq;
    private double differenceWithDep;

    @Enumerated(EnumType.STRING)
    private BalanceType balanceType;

    public OverallBalance() {
    }

    public OverallBalance(CustomUser user, Date date, double balanceLiq, double balanceWithDep, BalanceType balanceType) {
        this.user = user;
        this.date = date;
        this.balanceLiq = balanceLiq;
        this.balanceWithDep = balanceWithDep;
        this.balanceType = balanceType;
    }

    public OverallBalance(CustomUser user, Date date, double balanceLiq, double balanceWithDep, double differenceLiq,
                          double differenceWithDep, BalanceType balanceType) {
        this.user = user;
        this.date = date;
        this.balanceLiq = balanceLiq;
        this.balanceWithDep = balanceWithDep;
        this.differenceLiq = differenceLiq;
        this.differenceWithDep = differenceWithDep;
        this.balanceType = balanceType;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getBalanceLiq() {
        return balanceLiq;
    }

    public void setBalanceLiq(double balanceLiq) {
        this.balanceLiq = balanceLiq;
    }

    public double getBalanceWithDep() {
        return balanceWithDep;
    }

    public void setBalanceWithDep(double balanceWithDep) {
        this.balanceWithDep = balanceWithDep;
    }

    public double getDifferenceLiq() {
        return differenceLiq;
    }

    public void setDifferenceLiq(double differenceLiq) {
        this.differenceLiq = differenceLiq;
    }

    public double getDifferenceWithDep() {
        return differenceWithDep;
    }

    public void setDifferenceWithDep(double differenceWithDep) {
        this.differenceWithDep = differenceWithDep;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }
}
