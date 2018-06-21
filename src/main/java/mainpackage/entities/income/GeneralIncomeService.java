package mainpackage.entities.income;

public interface GeneralIncomeService {

    void addGeneralIncome(GeneralIncome generalIncome);

    void updateGeneralIncome(GeneralIncome generalIncome);

    void deleteGeneralIncome(Long id);

    GeneralIncome findLastEntry();

}
