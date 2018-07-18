package mainpackage;

import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.charity.Charity;
import mainpackage.entities.charity.CharityService;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRateService;
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
    if (purpose.equals("0")||periodicity.equals("0")) return this.errorEmptyStr(model);
    CustomUser dbUser = this.getCurrentUser();
    Date date = new Date();
    long curTime = date.getTime();
    long period = -1;
        switch (periodicity) {
            case "1_month":
                period = 1 * 30 * 24 * 60 * 60 * 1000;
                break;
            case "2_months":
                period = 2 * 30 * 24 * 60 * 60 * 1000;
                break;
            case "3_months":
                period = 3 * 30 * 24 * 60 * 60 * 1000;
                break;
            case "4_months":
                period = 4 * 30 * 24 * 60 * 60 * 1000;
                break;
            case "5_months":
                period = 5 * 30 * 24 * 60 * 60 * 1000;
                break;
            case "6_months":
                period = 6 * 30 * 24 * 60 * 60 * 1000;
                break;
            case "year":
                period = 365 * 24 * 60 * 60 * 1000;
                break;
        }
    /*
    if (period == -1) {}
    else {
            Date dateFrom = new Date(curTime - period);
    }
    */
        return "main_expenses_data_show";
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

}
