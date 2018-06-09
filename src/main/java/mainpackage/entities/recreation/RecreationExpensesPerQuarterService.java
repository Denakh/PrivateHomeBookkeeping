package mainpackage.entities.recreation;

import mainpackage.entities.charity.Charity;

public interface RecreationExpensesPerQuarterService {

    void addRecreationExpensesPerQuarter(RecreationExpensesPerQuarter recreationExpensesPerQuarter);

    void updateRecreationExpensesPerQuarter(RecreationExpensesPerQuarter recreationExpensesPerQuarter);

    void deleteRecreationExpensesPerQuarter(Long id);

}

