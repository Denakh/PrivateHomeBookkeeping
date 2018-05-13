package mainpackage.entities.currentexpensesrate;

import mainpackage.entities.users.CustomUser;

import javax.persistence.*;

@Entity
public class CurrentExpensesRate {

    @Id
    @GeneratedValue
    private long id;

    private CustomUser user;

    @Enumerated(EnumType.STRING)
    private MonthEn month;

    private double amount;


}