package mainpackage.entities.users;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import mainpackage.entities.ballancestatistics.BallanceStatistics;
import mainpackage.entities.charity.Charity;
import mainpackage.entities.communalpaystatistics.CommunalPayStatistics;
import mainpackage.entities.currentexpenses.CurrentExpenses;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRate;
import mainpackage.entities.debt.Debt;
import mainpackage.entities.deferrals.Deferrals;
import mainpackage.entities.exchangetransactions.ExchangeTransactions;
import mainpackage.entities.expensesfinancestatistics.ExpensesFinanceStatistics;
import mainpackage.entities.expensesfinancestatistics.ExpensesPerMonth;
import mainpackage.entities.expensesfinancestatistics.ExpensesPerQuater;
import mainpackage.entities.foreigncurrencies.ForeignCurrencies;
import mainpackage.entities.health.Health;
import mainpackage.entities.income.Income;
import mainpackage.entities.incomefinancestatistics.IncomeFinanceStatistics;
import mainpackage.entities.kidsandpets.KidsAndPets;
import mainpackage.entities.othercapitaloutlays.OtherCapitalOutlays;
import mainpackage.entities.overallbalance.OverallBalance;
import mainpackage.entities.recreation.Recreation;
import mainpackage.entities.reserve.Reserve;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomUser {
    @Id
    @GeneratedValue
    private long id;

    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String email;
    private String phone;
    /*
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<AllocationOfProfits> allocationOfProfits = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<BallanceStatistics> ballanceStatistics = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Charity> charity = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<CommunalPayStatistics> communalPayStatistics = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<CurrentExpenses> currentExpenses = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<CurrentExpensesRate> currentExpensesRate = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Debt> Debt = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Deferrals> deferrals = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<ExchangeTransactions> exchangeTransactions = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<ExpensesFinanceStatistics> expensesFinanceStatistics = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<ExpensesPerMonth> expensesPerMonth = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<ExpensesPerQuater> expensesPerQuater = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<ForeignCurrencies> foreignCurrencies = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Health> health = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Income> income = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<IncomeFinanceStatistics> incomeFinanceStatistics = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<KidsAndPets> kidsAndPets = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<OtherCapitalOutlays> otherCapitalOutlays = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<OverallBalance> overallBalance = new ArrayList<>();

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Recreation> recreation = new ArrayList<>();
    */
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Reserve> reserve = new ArrayList<>();


    public CustomUser(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public CustomUser(String login, String password, UserRole role, String email, String phone) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    public CustomUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
/*
    public List<AllocationOfProfits> getAllocationOfProfits() {
        return allocationOfProfits;
    }

    public void setAllocationOfProfits(List<AllocationOfProfits> allocationOfProfits) {
        this.allocationOfProfits = allocationOfProfits;
    }

    public List<BallanceStatistics> getBallanceStatistics() {
        return ballanceStatistics;
    }

    public void setBallanceStatistics(List<BallanceStatistics> ballanceStatistics) {
        this.ballanceStatistics = ballanceStatistics;
    }

    public List<Charity> getCharity() {
        return charity;
    }

    public void setCharity(List<Charity> charity) {
        this.charity = charity;
    }

    public List<CommunalPayStatistics> getCommunalPayStatistics() {
        return communalPayStatistics;
    }

    public void setCommunalPayStatistics(List<CommunalPayStatistics> communalPayStatistics) {
        this.communalPayStatistics = communalPayStatistics;
    }

    public List<CurrentExpenses> getCurrentExpenses() {
        return currentExpenses;
    }

    public void setCurrentExpenses(List<CurrentExpenses> currentExpenses) {
        this.currentExpenses = currentExpenses;
    }

    public List<CurrentExpensesRate> getCurrentExpensesRate() {
        return currentExpensesRate;
    }

    public void setCurrentExpensesRate(List<CurrentExpensesRate> currentExpensesRate) {
        this.currentExpensesRate = currentExpensesRate;
    }

    public List<mainpackage.entities.debt.Debt> getDebt() {
        return Debt;
    }

    public void setDebt(List<mainpackage.entities.debt.Debt> debt) {
        Debt = debt;
    }

    public List<Deferrals> getDeferrals() {
        return deferrals;
    }

    public void setDeferrals(List<Deferrals> deferrals) {
        this.deferrals = deferrals;
    }

    public List<ExchangeTransactions> getExchangeTransactions() {
        return exchangeTransactions;
    }

    public void setExchangeTransactions(List<ExchangeTransactions> exchangeTransactions) {
        this.exchangeTransactions = exchangeTransactions;
    }

    public List<ExpensesFinanceStatistics> getExpensesFinanceStatistics() {
        return expensesFinanceStatistics;
    }

    public void setExpensesFinanceStatistics(List<ExpensesFinanceStatistics> expensesFinanceStatistics) {
        this.expensesFinanceStatistics = expensesFinanceStatistics;
    }

    public List<ExpensesPerMonth> getExpensesPerMonth() {
        return expensesPerMonth;
    }

    public void setExpensesPerMonth(List<ExpensesPerMonth> expensesPerMonth) {
        this.expensesPerMonth = expensesPerMonth;
    }

    public List<ExpensesPerQuater> getExpensesPerQuater() {
        return expensesPerQuater;
    }

    public void setExpensesPerQuater(List<ExpensesPerQuater> expensesPerQuater) {
        this.expensesPerQuater = expensesPerQuater;
    }

    public List<ForeignCurrencies> getForeignCurrencies() {
        return foreignCurrencies;
    }

    public void setForeignCurrencies(List<ForeignCurrencies> foreignCurrencies) {
        this.foreignCurrencies = foreignCurrencies;
    }

    public List<Health> getHealth() {
        return health;
    }

    public void setHealth(List<Health> health) {
        this.health = health;
    }

    public List<Income> getIncome() {
        return income;
    }

    public void setIncome(List<Income> income) {
        this.income = income;
    }

    public List<IncomeFinanceStatistics> getIncomeFinanceStatistics() {
        return incomeFinanceStatistics;
    }

    public void setIncomeFinanceStatistics(List<IncomeFinanceStatistics> incomeFinanceStatistics) {
        this.incomeFinanceStatistics = incomeFinanceStatistics;
    }

    public List<KidsAndPets> getKidsAndPets() {
        return kidsAndPets;
    }

    public void setKidsAndPets(List<KidsAndPets> kidsAndPets) {
        this.kidsAndPets = kidsAndPets;
    }

    public List<OtherCapitalOutlays> getOtherCapitalOutlays() {
        return otherCapitalOutlays;
    }

    public void setOtherCapitalOutlays(List<OtherCapitalOutlays> otherCapitalOutlays) {
        this.otherCapitalOutlays = otherCapitalOutlays;
    }

    public List<OverallBalance> getOverallBalance() {
        return overallBalance;
    }

    public void setOverallBalance(List<OverallBalance> overallBalance) {
        this.overallBalance = overallBalance;
    }

    public List<Recreation> getRecreation() {
        return recreation;
    }

    public void setRecreation(List<Recreation> recreation) {
        this.recreation = recreation;
    }
*/
    public List<Reserve> getReserve() {
        return reserve;
    }

    public void setReserve(List<Reserve> reserve) {
       this.reserve = reserve;
   }

}
