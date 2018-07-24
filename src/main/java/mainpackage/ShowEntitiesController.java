package mainpackage;

import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.charity.Charity;
import mainpackage.entities.charity.CharityService;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRateService;
import mainpackage.entities.debt.DebtService;
import mainpackage.entities.health.Health;
import mainpackage.entities.health.HealthService;
import mainpackage.entities.income.GeneralIncomeService;
import mainpackage.entities.income.IncomeService;
import mainpackage.entities.kidsandpets.KidsAndPets;
import mainpackage.entities.kidsandpets.KidsAndPetsService;
import mainpackage.entities.othercapitaloutlays.OtherCapitalOutlays;
import mainpackage.entities.othercapitaloutlays.OtherCapitalOutlaysService;
import mainpackage.entities.recreation.Recreation;
import mainpackage.entities.recreation.RecreationService;
import mainpackage.entities.reserve.Reserve;
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
    private CurrentExpensesRateService currentExpensesRateService;
    @Autowired
    private DebtService debtService;

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
                                 @RequestParam(defaultValue = "0") String periodicity,
                                 Model model) {
        if (purpose.equals("0") || periodicity.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        Date dateFrom;
        long curTime = date.getTime();
        long period = getPeriod(periodicity);
        if (period == -1) dateFrom = new Date(0);
        else dateFrom = new Date(curTime - period);
        entitiesShow(purpose, dbUser, dateFrom, model);
        return "main_expenses_data_show";
    }

    @RequestMapping("/debt_show")
    public String debtGettingExe(@RequestParam(defaultValue = "0") String periodicity,
                                 Model model) {
        if (periodicity.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        Date dateFrom;
        long curTime = date.getTime();
        long period = getPeriod(periodicity);
        if (period == -1) dateFrom = new Date(0);
        else dateFrom = new Date(curTime - period);
        debtsShow(dbUser, dateFrom, model);
        return "debt_show";
    }

    @RequestMapping("/income_show")
    public String incomeGettingExe(@RequestParam(defaultValue = "0") String periodicity,
                                   Model model) {
        if (periodicity.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        Date dateFrom;
        long curTime = date.getTime();
        long period = getPeriod(periodicity);
        if (period == -1) dateFrom = new Date(0);
        else dateFrom = new Date(curTime - period);
        incomsShow(dbUser, dateFrom, model);
        return "income_show";
    }

    /*
    @RequestMapping("/allocation_of_profits_show")
    public String allocationOfProfitsShow() {
        return "allocation_of_profits_table";
    }

    @RequestMapping("/communalpay_statistic_show")
    public String communalPayStatisticShow() {
        return "communalpay_statistic_table";
    }
    */

    private String errorEmptyStr(Model model) {
        String errorStr = "Not choose variant in list. Try again";
        model.addAttribute("error_message", errorStr);
        return "/input_error";
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
                break;
            case "health":
                model.addAttribute("expEntityList", healthService.findEntriesFromDate(dbUser, date));
                break;
            case "kids_and_pets":
                model.addAttribute("expEntityList", kidsAndPetsService.findEntriesFromDate(dbUser, date));
                break;
            case "other_capoutlays":
                model.addAttribute("expEntityList", otherCapitalOutlaysService.findEntriesFromDate(dbUser, date));
                break;
            case "recreation":
                model.addAttribute("expEntityList", recreationService.findEntriesFromDate(dbUser, date));
                break;
            case "reserve":
                model.addAttribute("expEntityList", reserveService.findEntriesFromDate(dbUser, date));
                break;
        }
    }

    private void debtsShow(CustomUser dbUser, Date date, Model model) {
        model.addAttribute("debtEntityList", debtService.findEntriesFromDate(dbUser, date));
    }

    private void incomsShow(CustomUser dbUser, Date date, Model model) {
        model.addAttribute("incomeEntityList", incomeService.findEntriesFromDate(dbUser, date));
    }

    private long getPeriod(String periodicity) {
        long period = -1;
        switch (periodicity) {
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
