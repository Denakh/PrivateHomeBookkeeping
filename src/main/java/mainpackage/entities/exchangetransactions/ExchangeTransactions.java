package mainpackage.entities.exchangetransactions;

import mainpackage.entities.foreigncurrencies.Currencies;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;

@Entity
public class ExchangeTransactions {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private CustomUser user;

    @Enumerated(EnumType.STRING)
    private CurrencyOperationType currencyOperationType;

    @Enumerated(EnumType.STRING)
    private Currencies currency;

    private double amount;

    private double exchangerate;

    private double exchangeprofit;

}
