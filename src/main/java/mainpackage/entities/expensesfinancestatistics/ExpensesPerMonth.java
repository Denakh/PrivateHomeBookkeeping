package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.ItemOfExpenses;
import mainpackage.entities.users.CustomUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class ExpensesPerMonth {

    @Id
    @GeneratedValue
    private long id;

    private CustomUser user;

    private List<ItemOfExpenses> expensesByTypes = new ArrayList<>();

    private double totalExpenses1MonthAgo;

    private double totalExpenses2MonthAgo;

    private double totalExpenses3MonthAgo;

    private double totalExpenses4MonthAgo;

    private double totalExpenses5MonthAgo;

    private double totalExpenses6MonthAgo;

    private double totalExpenses7MonthAgo;

    private double totalExpenses8MonthAgo;

    private double totalExpenses9MonthAgo;

    private double totalExpenses10MonthAgo;

    private double totalExpenses11MonthAgo;

    private double totalExpenses12MonthAgo;


}