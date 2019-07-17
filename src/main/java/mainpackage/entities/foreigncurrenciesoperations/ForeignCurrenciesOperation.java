package mainpackage.entities.foreigncurrenciesoperations;

import mainpackage.entities.foreigncurrencies.Currencies;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ForeignCurrenciesOperation {

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

    @Enumerated(EnumType.STRING)
    private ForeignCurrenciesOperationType operationName;

    private double amountChangeDuringOperation;

    private double operationExchangeRate;

    private double newAmount;

    public ForeignCurrenciesOperation() {
    }

    public ForeignCurrenciesOperation(CustomUser user, Date date, Currencies currency,
                                      ForeignCurrenciesOperationType operationName, double amountChangeDuringOperation,
                                      double operationExchangeRate, double newAmount) {
        this.user = user;
        this.date = date;
        this.currency = currency;
        this.operationName = operationName;
        this.amountChangeDuringOperation = amountChangeDuringOperation;
        this.operationExchangeRate = operationExchangeRate;
        this.newAmount = newAmount;
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

    public ForeignCurrenciesOperationType getOperationName() {
        return operationName;
    }

    public void setOperationName(ForeignCurrenciesOperationType operationName) {
        this.operationName = operationName;
    }

    public double getAmountChangeDuringOperation() {
        return amountChangeDuringOperation;
    }

    public void setAmountChangeDuringOperation(double amountChangeDuringOperation) {
        this.amountChangeDuringOperation = amountChangeDuringOperation;
    }

    public double getOperationExchangeRate() {
        return operationExchangeRate;
    }

    public void setOperationExchangeRate(double operationExchangeRate) {
        this.operationExchangeRate = operationExchangeRate;
    }

    public double getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(double newAmount) {
        this.newAmount = newAmount;
    }

}
