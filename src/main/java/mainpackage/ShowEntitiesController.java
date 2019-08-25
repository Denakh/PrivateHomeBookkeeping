package mainpackage;

import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.charity.CharityService;
import mainpackage.entities.communalpaystatistics.CommunalPayStatisticsService;
import mainpackage.entities.currentexpenses.CurrentExpensesService;
import mainpackage.entities.debt.DebtService;
import mainpackage.entities.deferrals.DeferralsService;
import mainpackage.entities.foreigncurrenciesoperations.ForeignCurrenciesOperationService;
import mainpackage.entities.health.HealthService;
import mainpackage.entities.income.GeneralIncomeService;
import mainpackage.entities.income.IncomeService;
import mainpackage.entities.kidsandpets.KidsAndPetsService;
import mainpackage.entities.othercapitaloutlays.OtherCapitalOutlaysService;
import mainpackage.entities.recreation.RecreationService;
import mainpackage.entities.reserve.ReserveService;
import mainpackage.entities.users.CustomUser;
import mainpackage.entities.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class ShowEntitiesController {

    @Autowired
    private UserService userService;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private CharityService charityService;
    @Autowired
    private HealthService healthService;
    @Autowired
    private KidsAndPetsService kidsAndPetsService;
    @Autowired
    private OtherCapitalOutlaysService otherCapitalOutlaysService;
    @Autowired
    private RecreationService recreationService;
    @Autowired
    private ReserveService reserveService;
    @Autowired
    private GeneralIncomeService generalIncomeService;
    @Autowired
    private AllocationOfProfitsService allocationOfProfitsService;
    @Autowired
    private DebtService debtService;
    @Autowired
    private CurrentExpensesService currentExpensesService;
    @Autowired
    private CommunalPayStatisticsService communalPayStatisticsService;
    @Autowired
    private DeferralsService deferralsService;
    @Autowired
    private ForeignCurrenciesOperationService foreignCurrenciesOperationService;

    @RequestMapping("/data_getting")
    public String dataGetting() {
        return "data_getting";
    }

    @RequestMapping("/financial_analysis")
    public String financialAnalysis() {
        return "financial_analysis";
    }

    @RequestMapping("/data_getting_execute")
    public String dataGettingExe(@RequestParam(defaultValue = "0") String purpose,
                                 @RequestParam(defaultValue = "0") String per,
                                 Model model) {
        if (purpose.equals("0") || per.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        Date dateFrom;
        long curTime = date.getTime();
        long period = getPeriod(per);
        if (period == -1) dateFrom = new Date(0);
        else dateFrom = new Date(curTime - period);
        this.entitiesShow(purpose, dbUser, dateFrom, model);
        return "main_expenses_data_show";
    }

    @RequestMapping("/ce_data_getting_execute")
    public String curExpDataGettingExe(@RequestParam(defaultValue = "0") String per,
                                       Model model) {
        if (per.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        Date dateFrom;
        long curTime = date.getTime();
        long period = getPeriod(per);
        if (period == -1) dateFrom = new Date(0);
        else dateFrom = new Date(curTime - period);
        this.curExpShow(dbUser, dateFrom, model);
        return "current_expenses_data_show";
    }

    @RequestMapping("/debt_show")
    public String debtGettingExe(@RequestParam(defaultValue = "0") String per,
                                 Model model) {
        if (per.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        Date dateFrom;
        long curTime = date.getTime();
        long period = getPeriod(per);
        if (period == -1) dateFrom = new Date(0);
        else dateFrom = new Date(curTime - period);
        this.debtsShow(dbUser, dateFrom, model);
        return "debt_show";
    }

    @RequestMapping("/income_show")
    public String incomeGettingExe(@RequestParam(defaultValue = "0") String per,
                                   Model model) {
        if (per.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        Date dateFrom;
        long curTime = date.getTime();
        long period = getPeriod(per);
        if (period == -1) dateFrom = new Date(0);
        else dateFrom = new Date(curTime - period);
        this.incomsShow(dbUser, dateFrom, model);
        return "income_show";
    }

    @RequestMapping("/get_users_jsp")
    public String usersGettingExe(Model model) {
        List<CustomUser> users = userService.getUsers();
        model.addAttribute("usersList", users);
        return "users_show";
    }

    @RequestMapping("/allocation_of_profits_show")
    public String allocationOfProfitsGettingExe(Model model) {
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        long curTime = date.getTime();
        long period = getPeriod("year");
        Date dateFrom = new Date(curTime - period);
        model.addAttribute("allocationOfProfitsList", allocationOfProfitsService.findEntriesFromDate(dbUser, dateFrom));
        return "allocation_of_profits_show";
    }

    @RequestMapping("/communalpay_statistic_show")
    public String communalPayStatisticGettingExe(@RequestParam(defaultValue = "0") String per,
                                                 Model model) {
        if (per.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        Date dateFrom;
        long curTime = date.getTime();
        long period = getPeriod(per);
        if (period == -1) dateFrom = new Date(0);
        else dateFrom = new Date(curTime - period);
        this.communalPayStatisticShow(dbUser, dateFrom, model);
        return "communalpay_statistic_show";
    }

    @RequestMapping("/deferrals_show")
    public String deferralsGettingExe(@RequestParam(defaultValue = "0") String per,
                                      Model model) {
        if (per.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        Date dateFrom;
        long curTime = date.getTime();
        long period = getPeriod(per);
        if (period == -1) dateFrom = new Date(0);
        else dateFrom = new Date(curTime - period);
        this.deferralsShow(dbUser, dateFrom, model);
        return "deferrals_show";
    }

    @RequestMapping("/foreign_currencies_transactions")
    public String foreignCurrenciesTransactionsGettingExe(@RequestParam(defaultValue = "0") String per,
                                                          Model model) {
        if (per.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        Date dateFrom;
        long curTime = date.getTime();
        long period = getPeriod(per);
        if (period == -1) dateFrom = new Date(0);
        else dateFrom = new Date(curTime - period);
        this.foreignCurrenciesTransactionsShow(dbUser, dateFrom, model);
        return "foreign_currencies_transactions_show";
    }

    private String errorEmptyStr(Model model) {
        String errorStr = "Not choose variant in list. Try again";
        model.addAttribute("error_message", errorStr);
        return "input_error";
    }

    private CustomUser getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();
        return userService.getUserByLogin(login);
    }

    private void entitiesShow(String purpose, CustomUser dbUser, Date date, Model model) {
        switch (purpose) {
            case "charity":
                model.addAttribute("expEntityList", charityService.findEntriesFromDate(dbUser, date));
                model.addAttribute("expEntityName", "charity");
                break;
            case "health":
                model.addAttribute("expEntityList", healthService.findEntriesFromDate(dbUser, date));
                model.addAttribute("expEntityName", "health");
                break;
            case "kids_and_pets":
                model.addAttribute("expEntityList", kidsAndPetsService.findEntriesFromDate(dbUser, date));
                model.addAttribute("expEntityName", "kids and pets");
                break;
            case "other_capoutlays":
                model.addAttribute("expEntityList", otherCapitalOutlaysService.findEntriesFromDate(dbUser, date));
                model.addAttribute("expEntityName", "other capital outlays");
                break;
            case "recreation":
                model.addAttribute("expEntityList", recreationService.findEntriesFromDate(dbUser, date));
                model.addAttribute("expEntityName", "recreation");
                break;
            case "reserve":
                model.addAttribute("expEntityList", reserveService.findEntriesFromDate(dbUser, date));
                model.addAttribute("expEntityName", "reserve");
                break;
        }
    }

    private void curExpShow(CustomUser dbUser, Date date, Model model) {
        model.addAttribute("curExpEntityList", currentExpensesService.findEntriesFromDate(dbUser, date));
    }

    private void debtsShow(CustomUser dbUser, Date date, Model model) {
        model.addAttribute("debtEntityList", debtService.findEntriesFromDate(dbUser, date));
    }

    private void communalPayStatisticShow(CustomUser dbUser, Date date, Model model) {
        model.addAttribute("communalPayStatisticEntityList", communalPayStatisticsService.findEntriesFromDate(dbUser, date));
    }

    private void incomsShow(CustomUser dbUser, Date date, Model model) {
        model.addAttribute("incomeEntityList", incomeService.findEntriesFromDate(dbUser, date));
        model.addAttribute("gIncomeEntityList", generalIncomeService.findEntriesFromDate(dbUser, date));
    }

    private void deferralsShow(CustomUser dbUser, Date date, Model model) {
        model.addAttribute("deferralsEntityList", deferralsService.findEntriesFromDate(dbUser, date));
    }

    private void foreignCurrenciesTransactionsShow(CustomUser dbUser, Date date, Model model) {
        model.addAttribute("foreignCurrenciesTransactionsList", foreignCurrenciesOperationService.findEntriesFromDate(dbUser, date));
    }


    private long getPeriod(String per) {
        long period = -1;
        switch (per) {
            case "1_month":
                period = 2592000000L;
                break;
            case "2_months":
                period = 5184000000L;
                break;
            case "3_months":
                period = 7776000000L;
                break;
            case "4_months":
                period = 10368000000L;
                break;
            case "5_months":
                period = 12960000000L;
                break;
            case "6_months":
                period = 15552000000L;
                break;
            case "year":
                period = 31536000000L;
                break;
        }
        return period;
    }

}
