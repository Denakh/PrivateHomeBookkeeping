package mainpackage.entities.expensesfinancestatistics;

import mainpackage.entities.ItemOfExpenses;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExpensesPerQuater {

    private List<ItemOfExpenses> expensesByTypes = new ArrayList<>();

    private double totalExpenses1QuaterAgo;

    private double totalExpenses2QuaterAgo;

    private double totalExpenses3QuaterAgo;

    private double totalExpenses4QuaterAgo;

}
