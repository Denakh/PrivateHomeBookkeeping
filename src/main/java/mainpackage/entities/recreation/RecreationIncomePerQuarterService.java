package mainpackage.entities.recreation;

import mainpackage.entities.charity.Charity;

public interface RecreationIncomePerQuarterService {

    void addRecreationIncomePerQuarter(RecreationIncomePerQuarter recreationIncomePerQuarter);

    void updateRecreationIncomePerQuarter(RecreationIncomePerQuarter recreationIncomePerQuarter);

    void deleteRecreationIncomePerQuarter(Long id);

}
