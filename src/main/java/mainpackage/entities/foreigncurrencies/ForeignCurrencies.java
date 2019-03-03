package mainpackage.entities.foreigncurrencies;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ForeignCurrencies {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    @Enumerated(EnumType.STRING)
    private Currencies currency;

    private double amount;

    private double conventionalExchangeRate;

    public ForeignCurrencies() {
    }

    public ForeignCurrencies(CustomUser user, Date date, Currencies currency, double amount,
                             double conventionalExchangeRate) {
        this.user = user;
        this.date = date;
        this.currency = currency;
        this.amount = amount;
        this.conventionalExchangeRate = conventionalExchangeRate;
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

    public Currencies getCurrency() {
        return currency;
    }

    public void setCurrency(Currencies currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getConventionalExchangeRate() {
        return conventionalExchangeRate;
    }

    public void setConventionalExchangeRate(double conventionalExchangeRate) {
        this.conventionalExchangeRate = conventionalExchangeRate;
    }

}
