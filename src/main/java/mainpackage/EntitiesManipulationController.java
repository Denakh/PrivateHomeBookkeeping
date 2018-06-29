package mainpackage;

import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.charity.Charity;
import mainpackage.entities.charity.CharityService;
import mainpackage.entities.health.Health;
import mainpackage.entities.health.HealthService;
import mainpackage.entities.income.GeneralIncome;
import mainpackage.entities.income.GeneralIncomeService;
import mainpackage.entities.income.Income;
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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class EntitiesManipulationController {

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


    @RequestMapping("/income_fixation")
    public String incomeFixation() {
        return "income_fixation";
    }

    @RequestMapping("/expense_fixation")
    public String expenseFixation() {
        return "expense_fixation";
    }

    @RequestMapping("/debt_fixation")
    public String deptFixation() {
        return "debt_fixation";
    }

    @RequestMapping("/deferral_fixation")
    public String deferralsFixation() {
        return "deferral_fixation";
    }

    @RequestMapping("/communal_pays_fixation")
    public String communalpaysFixation() {
        return "communalpay_fixation";
    }

    @RequestMapping("/current_expenses_rate")
    public String currentExpensesRateSetup() {
        return "current_exp_rate_setup";
    }

    @RequestMapping("/foreign_currencies")
    public String foreignCurrenciesOperations() {
        return "foreign_currencies_operations";
    }

    @RequestMapping("/allocation_of_profits")
    public String allocationOfProfits() {
        return "allocation_of_profits";
    }

    @RequestMapping("/data_getting")
    public String dataGetting() {
        return "data_getting";
    }

    @RequestMapping("/financial_analysis")
    public String financialAnalysis() {
        return "financial_analysis";
    }

    @RequestMapping("/income_fixation_execute")
    public String incomeFixationExecute(@RequestParam String amount,
                                        @RequestParam String description,
                                        @RequestParam String purpose,
                                        Model model) {
        double damount;
        String errorStr = "";
        try {
            damount = Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            errorStr = "Number format error. Try again";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();
        CustomUser dbUser = userService.getUserByLogin(login);
        Date date = new Date();
        Income income = new Income(dbUser, damount, date, description, purpose);
        if (purpose.equals("general")) {
            GeneralIncome generalIncomePrev = generalIncomeService.findLastEntry();
            GregorianCalendar gcalendar = (GregorianCalendar) GregorianCalendar.getInstance();
            gcalendar.setTime(date);
            double accumulation = generalIncomePrev.getAccumulation() + damount;
            double excessForAllocation = 0;
            byte monthNumber = generalIncomePrev.getMonthNumber();
            boolean monthCheck1 = gcalendar.get(Calendar.MONTH) + 1 < monthNumber;
            boolean monthCheck2 = gcalendar.get(Calendar.MONTH) + 1 >= 11 && monthNumber <= 2;
            if (accumulation > 6600 && (monthCheck1 || monthCheck2)) {
                excessForAllocation = accumulation - 6600;
            }
            if (!(monthCheck1 || monthCheck2) && accumulation > 6600) {
                accumulation = accumulation - 6600;
                if (monthNumber != 12) monthNumber += 1;
                else monthNumber = 1;
            }
            GeneralIncome generalIncome = new GeneralIncome(damount, date, monthNumber, accumulation, excessForAllocation);
            generalIncomeService.addGeneralIncome(generalIncome);
            income.setGeneralIncome(generalIncome);
        }
        incomeService.addIncome(income);
        double am = 0;
        boolean res = this.entitiesAdd(purpose, dbUser, damount, date, description, am);
        if (res) return "redirect:/";
        else {
            errorStr = "Purpose error. Try again";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
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

    private boolean entitiesAdd(String purpose, CustomUser dbUser, double damount, Date date, String description,
                                double am) {
        switch (purpose) {
            case "charity":
                Charity c = charityService.findLastEntry();
                if (c != null) am = c.getAmount();
                charityService.addCharity(new Charity(dbUser, damount, date, description, am + damount));
                break;
            case "health":
                Health h = healthService.findLastEntry();
                if (h != null) am = h.getAmount();
                healthService.addHealth(new Health(dbUser, damount, date, description, am + damount));
                break;
            case "kids_and_pets":
                KidsAndPets k = kidsAndPetsService.findLastEntry();
                if (k != null) am = k.getAmount();
                kidsAndPetsService.addKidsAndPets(new KidsAndPets(dbUser, damount, date, description,
                        am + damount));
                break;
            case "other_capoutlays":
                OtherCapitalOutlays o = otherCapitalOutlaysService.findLastEntry();
                if (o != null) am = o.getAmount();
                otherCapitalOutlaysService.addOtherCapitalOutlays(new OtherCapitalOutlays(dbUser, damount, date,
                        description, am + damount));
                break;
            case "recreation":
                Recreation rec = recreationService.findLastEntry();
                if (rec != null) am = rec.getAmount();
                recreationService.addRecreation(new Recreation(dbUser, damount, date, description,
                        am + damount));
                break;
            case "reserve":
                Reserve res = reserveService.findLastEntry();
                if (res != null) am = res.getAmount();
                reserveService.addReserve(new Reserve(dbUser, damount, date, description, am + damount));
                break;
            case "general":
                break;
            default:
                return false;
        }
        return true;
    }

}
