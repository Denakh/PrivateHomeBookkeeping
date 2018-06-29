package mainpackage.entities.currentexpenses;

public interface CurrentExpensesService {

    void addCurrentExpenses(CurrentExpenses currentExpenses);

    void updateCurrentExpenses(CurrentExpenses currentExpenses);

    void deleteCurrentExpenses(Long id);

}
