package mainpackage.entities.exchangetransactions;

import mainpackage.entities.foreigncurrencies.Currencies;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ExchangeTransactions {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    //@Column(name = "msg_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    @Enumerated(EnumType.STRING)
    private CurrencyOperationType currencyOperationType;

    @Enumerated(EnumType.STRING)
    private Currencies currency;

    private double amount;

    private double exchangerate;

    private double exchangeprofit;

    public ExchangeTransactions() {
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

    public CurrencyOperationType getCurrencyOperationType() {
        return currencyOperationType;
    }

    public void setCurrencyOperationType(CurrencyOperationType currencyOperationType) {
        this.currencyOperationType = currencyOperationType;
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

    public double getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(double exchangerate) {
        this.exchangerate = exchangerate;
    }

    public double getExchangeprofit() {
        return exchangeprofit;
    }

    public void setExchangeprofit(double exchangeprofit) {
        this.exchangeprofit = exchangeprofit;
    }
}
