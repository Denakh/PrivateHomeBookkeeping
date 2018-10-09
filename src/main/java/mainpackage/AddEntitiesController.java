package mainpackage;

import mainpackage.currentcurrenciesinfo.GetCurrentCurrenciesInfo;
import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.charity.Charity;
import mainpackage.entities.charity.CharityService;
import mainpackage.entities.communalpaystatistics.CommunalPayStatistics;
import mainpackage.entities.communalpaystatistics.CommunalPayStatisticsService;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRate;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRateService;
import mainpackage.entities.debt.Debt;
import mainpackage.entities.debt.DebtService;
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
public class AddEntitiesController {

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
    @Autowired
    private CommunalPayStatisticsService communalPayStatisticsService;
    @Autowired
    private GetCurrentCurrenciesInfo getCurrentCurrenciesInfo;

    @RequestMapping("/income_fixation")
    public String incomeFixation() {
        return "income_fixation";
    }

    @RequestMapping("/expense_fixation")
    public String expenseFixation() {
        return "expense_fixation";
    }

    @RequestMapping("/debt_fixation")
    public String deptFixation(Model model) {
        CustomUser dbUser = this.getCurrentUser();
        model.addAttribute("debts", debtService.findEffectiveDebtsList(dbUser));
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
    public String currentExpensesRateSetup(Model model) {
        CustomUser dbUser = this.getCurrentUser();
        model.addAttribute("currentExpensesRate", currentExpensesRateService.findLastEntry(dbUser));
        return "current_exp_rate_setup";
    }

    @RequestMapping("/foreign_currencies")
    public String foreignCurrenciesOperations(Model model) {
        //String jsonString = getCurrentCurrenciesInfo.getCurrenciesInfoFromFinanceUa();
        String jsonString = "Some info...";
        model.addAttribute("json", jsonString);
        return "foreign_currencies_operations";
    }

    @RequestMapping("/allocation_of_profits")
    public String allocationOfProfits(Model model) {
        CustomUser dbUser = this.getCurrentUser();
        model.addAttribute("allocationOfProfits", allocationOfProfitsService.findLastEntry(dbUser));
        return "allocation_of_profits";
    }

    @RequestMapping("/income_fixation_execute")
    public String incomeFixationExecute(@RequestParam String amount,
                                        @RequestParam String description,
                                        @RequestParam(defaultValue = "0") String purpose,
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
        if (purpose.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        Income income = new Income(dbUser, damount, date, description, purpose);
        if (purpose.equals("general")) {
            this.entitiesAddFromGeneral(dbUser, damount, date, description, income);
            return "redirect:/";
        }
        incomeService.addIncome(income);
        double am = 0;
        boolean res = this.entitiesAdd(purpose, dbUser, damount, date, description, am);
        return this.returnResPage(res, model);
    }

    @RequestMapping("/expense_fixation_execute")
    public String expenseFixationExecute(@RequestParam String amount_change,
                                         @RequestParam String description,
                                         @RequestParam(defaultValue = "0") String purpose,
                                         Model model) {
        double damount;
        String errorStr = "";
        try {
            damount = -1 * Double.parseDouble(amount_change);
        } catch (NumberFormatException e) {
            errorStr = "Number format error. Try again";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
        if (purpose.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        double am = 0;
        boolean res = this.entitiesAdd(purpose, dbUser, damount, date, description, am);
        return this.returnResPage(res, model);
    }

    @RequestMapping("/allocation_of_profits_execute")
    public String incomeFixationExecute(@RequestParam String charity_percent,
                                        @RequestParam String health_percent,
                                        @RequestParam String kids_and_pets_percent,
                                        @RequestParam String other_capoutlays_percent,
                                        @RequestParam String recreation_percent,
                                        @RequestParam String reserve_percent,
                                        Model model) {
        double dcharityPercent, dhealthPercent, dkidsandpetsPercent, dothercapoutlaysPercent, drecreationPercent, dreservePercent, percentSum;
        String errorStr = "";
        try {
            dcharityPercent = Double.parseDouble(charity_percent);
            dhealthPercent = Double.parseDouble(health_percent);
            dkidsandpetsPercent = Double.parseDouble(kids_and_pets_percent);
            dothercapoutlaysPercent = Double.parseDouble(other_capoutlays_percent);
            drecreationPercent = Double.parseDouble(recreation_percent);
            dreservePercent = Double.parseDouble(reserve_percent);
        } catch (NumberFormatException e) {
            errorStr = "Number format error. Try again";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
        percentSum = dcharityPercent + dhealthPercent + dkidsandpetsPercent + dothercapoutlaysPercent +
                drecreationPercent + dreservePercent;
        if (percentSum != 100) {
            errorStr = "Percent sum isn't equal 100. Try again";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        allocationOfProfitsService.addAllocationOfProfits(new AllocationOfProfits(dbUser, date, dcharityPercent, dhealthPercent,
                dkidsandpetsPercent, dothercapoutlaysPercent, drecreationPercent, dreservePercent));
        return "redirect:/";
    }

    @RequestMapping("/current_expenses_rate_execute")
    public String currentExpensesRateAdd(@RequestParam String amount1,
                                         @RequestParam String amount2,
                                         @RequestParam String amount3,
                                         @RequestParam String amount4,
                                         @RequestParam String amount5,
                                         @RequestParam String amount6,
                                         @RequestParam String amount7,
                                         @RequestParam String amount8,
                                         @RequestParam String amount9,
                                         @RequestParam String amount10,
                                         @RequestParam String amount11,
                                         @RequestParam String amount12,
                                         Model model) {
        double damount1, damount2, damount3, damount4, damount5, damount6, damount7, damount8, damount9, damount10, damount11, damount12;
        String errorStr = "";
        try {
            damount1 = Double.parseDouble(amount1);
            damount2 = Double.parseDouble(amount2);
            damount3 = Double.parseDouble(amount3);
            damount4 = Double.parseDouble(amount4);
            damount5 = Double.parseDouble(amount5);
            damount6 = Double.parseDouble(amount6);
            damount7 = Double.parseDouble(amount7);
            damount8 = Double.parseDouble(amount8);
            damount9 = Double.parseDouble(amount9);
            damount10 = Double.parseDouble(amount10);
            damount11 = Double.parseDouble(amount11);
            damount12 = Double.parseDouble(amount12);
        } catch (NumberFormatException e) {
            errorStr = "Number format error. Try again";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        currentExpensesRateService.addCurrentExpensesRate(new CurrentExpensesRate(dbUser, date, damount1, damount2, damount3,
                damount4, damount5, damount6, damount7, damount8, damount9, damount10, damount11, damount12));
        return "redirect:/";
    }

    @RequestMapping("/debt_fixation_execute")
    public String incomeFixationExecute(@RequestParam(defaultValue = "0") String amount,
                                        @RequestParam String description,
                                        @RequestParam(defaultValue = "-101") String percent,
                                        @RequestParam(defaultValue = "0") String purpose,
                                        @RequestParam(defaultValue = "0") String id_for_change,
                                        Model model) {
        double damount, dpercent;
        long idForChange;
        boolean percentForInitialAm = false;
        String errorStr = "";
        try {
            damount = Double.parseDouble(amount);
            dpercent = Double.parseDouble(percent);
            idForChange = Long.parseLong(id_for_change);
        } catch (NumberFormatException e) {
            errorStr = "Number format error. Try again";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
        if (purpose.equals("initial_amount")) percentForInitialAm = true;
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        if (idForChange > 0) return this.existingDebtChange(idForChange, damount, dbUser, date, description, dpercent,
                purpose, percentForInitialAm, model);
        if (purpose.equals("0")) return this.errorEmptyStr(model);
        if (dpercent == -101) dpercent = 0;
        debtService.addDebt(new Debt(dbUser, damount, date, description, percentForInitialAm, dpercent, damount));
        return "redirect:/";
    }

    @RequestMapping("/communalpay_fixation_execute")
    public String communalpayFixationExecute(@RequestParam String amount,
                                        @RequestParam String description,
                                        Model model) {
        double damount;
        String errorStr;
        try {
            damount = Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            errorStr = "Number format error in amount. Try again";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        CommunalPayStatistics communalPayStatistics = new CommunalPayStatistics(dbUser, damount, date, description);
        communalPayStatisticsService.addCommunalPayStatistics(communalPayStatistics);
        return "redirect:/";
    }

    private boolean entitiesAdd(String purpose, CustomUser dbUser, double damount, Date date, String description, double am) {
        switch (purpose) {
            case "charity":
                Charity c = charityService.findLastEntry(dbUser);
                if (c != null) am = c.getAmount();
                charityService.addCharity(new Charity(dbUser, damount, date, description, am + damount));
                break;
            case "health":
                Health h = healthService.findLastEntry(dbUser);
                if (h != null) am = h.getAmount();
                healthService.addHealth(new Health(dbUser, damount, date, description, am + damount));
                break;
            case "kids_and_pets":
                KidsAndPets k = kidsAndPetsService.findLastEntry(dbUser);
                if (k != null) am = k.getAmount();
                kidsAndPetsService.addKidsAndPets(new KidsAndPets(dbUser, damount, date, description, am + damount));
                break;
            case "other_capoutlays":
                OtherCapitalOutlays o = otherCapitalOutlaysService.findLastEntry(dbUser);
                if (o != null) am = o.getAmount();
                otherCapitalOutlaysService.addOtherCapitalOutlays(new OtherCapitalOutlays(dbUser, damount, date, description, am + damount));
                break;
            case "recreation":
                Recreation rec = recreationService.findLastEntry(dbUser);
                if (rec != null) am = rec.getAmount();
                recreationService.addRecreation(new Recreation(dbUser, damount, date, description,
                        am + damount));
                break;
            case "reserve":
                Reserve res = reserveService.findLastEntry(dbUser);
                if (res != null) am = res.getAmount();
                reserveService.addReserve(new Reserve(dbUser, damount, date, description, am + damount));
                break;
            default:
                return false;
        }
        return true;
    }

    private void entitiesAddFromGeneral(CustomUser dbUser, double damount, Date date, String description, Income income) {
        GeneralIncome generalIncomePrev = generalIncomeService.findLastEntry(dbUser);
        CurrentExpensesRate currentExpensesRate = currentExpensesRateService.findLastEntry(dbUser);
        GregorianCalendar gcalendar = (GregorianCalendar) GregorianCalendar.getInstance();
        gcalendar.setTime(date);
        if (generalIncomePrev == null) generalIncomePrev = this.getServGenIncObj(damount, gcalendar);
        byte monthNumber = generalIncomePrev.getMonthNumber();
        double accumulation = generalIncomePrev.getAccumulation() + damount;
        double excessForAllocationPrev = generalIncomePrev.getExcessForAllocation();
        double dcurrentExpensesRate = CurrentExpensesRate.getExpRateForMonthNum(monthNumber, currentExpensesRate);
        double excessForAllocationRest = 0;
        boolean monthCheck1 = gcalendar.get(Calendar.MONTH) + 1 < monthNumber;
        boolean monthCheck2 = gcalendar.get(Calendar.MONTH) + 1 >= 11 && monthNumber <= 2;
        if (accumulation > dcurrentExpensesRate && (monthCheck1 || monthCheck2)) {
            excessForAllocationRest = accumulation - dcurrentExpensesRate - excessForAllocationPrev;
        }
        double excessForAllocation = excessForAllocationPrev + excessForAllocationRest;
        if (!(monthCheck1 || monthCheck2)) {
            if (excessForAllocationPrev > 0) {
                excessForAllocation = 0;
                accumulation = damount;
                if (monthNumber != 12) monthNumber += 1;
                else monthNumber = 1;
            }
            if (accumulation > dcurrentExpensesRate) {
                accumulation = accumulation - dcurrentExpensesRate;
                if (monthNumber != 12) monthNumber += 1;
                else monthNumber = 1;
            }
        }
        GeneralIncome generalIncome = new GeneralIncome(dbUser, damount, date, monthNumber, accumulation, excessForAllocation);
        generalIncomeService.addGeneralIncome(generalIncome);
        income.setGeneralIncome(generalIncome);
        incomeService.addIncome(income);
        if (excessForAllocationRest > 0) {
            this.allocationOfProfitsExe(dbUser, excessForAllocationRest, date, description);
        }
    }

    private GeneralIncome getServGenIncObj(double damount, GregorianCalendar gcalendar) {
        GeneralIncome generalIncomePrev = new GeneralIncome();
        generalIncomePrev.setMonthNumber((byte) (gcalendar.get(Calendar.MONTH) + 1));
        generalIncomePrev.setAccumulation(damount);
        generalIncomePrev.setExcessForAllocation(0.01);
        return generalIncomePrev;
    }

    private void allocationOfProfitsExe(CustomUser dbUser, double excessForAllocationRest, Date date, String description) {
        double damount;
        AllocationOfProfits allocationOfProfits = allocationOfProfitsService.findLastEntry(dbUser);
        double am = 0;
        Charity c = charityService.findLastEntry(dbUser);
        if (c != null) am = c.getAmount();
        damount = allocationOfProfits.getCharityPercent() * excessForAllocationRest / 100;
        charityService.addCharity(new Charity(dbUser, damount, date, description, am + damount));
        am = 0;
        Health h = healthService.findLastEntry(dbUser);
        if (h != null) am = h.getAmount();
        damount = allocationOfProfits.getHealthPercent() * excessForAllocationRest / 100;
        healthService.addHealth(new Health(dbUser, damount, date, description, am + damount));
        am = 0;
        KidsAndPets k = kidsAndPetsService.findLastEntry(dbUser);
        if (k != null) am = k.getAmount();
        damount = allocationOfProfits.getKidsAndPetsPercent() * excessForAllocationRest / 100;
        kidsAndPetsService.addKidsAndPets(new KidsAndPets(dbUser, damount, date, description,
                am + damount));
        am = 0;
        OtherCapitalOutlays o = otherCapitalOutlaysService.findLastEntry(dbUser);
        if (o != null) am = o.getAmount();
        damount = allocationOfProfits.getOtherCapOutLaysPercent() * excessForAllocationRest / 100;
        otherCapitalOutlaysService.addOtherCapitalOutlays(new OtherCapitalOutlays(dbUser, damount, date,
                description, am + damount));
        am = 0;
        Recreation rec = recreationService.findLastEntry(dbUser);
        if (rec != null) am = rec.getAmount();
        damount = allocationOfProfits.getRecreationPercent() * excessForAllocationRest / 100;
        recreationService.addRecreation(new Recreation(dbUser, damount, date, description,
                am + damount));
        am = 0;
        Reserve res = reserveService.findLastEntry(dbUser);
        if (res != null) am = res.getAmount();
        damount = allocationOfProfits.getReservePercent() * excessForAllocationRest / 100;
        reserveService.addReserve(new Reserve(dbUser, damount, date, description, am + damount));
    }

    private String existingDebtChange(long debtId, double damount, CustomUser dbUser, Date date, String description,
                                      double dpercent, String purpose, boolean percentForInitialAm, Model model) {
        boolean mark = false;
        Debt debtForChange = debtService.findEntryById(dbUser, debtId);
        if (debtForChange == null) {
            String errorStr = "Error in debt id number";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
        if (damount != 0) {
            double newRemSum = debtForChange.getRemainingSum() + damount;
            if (newRemSum < 0) newRemSum = 0;
            debtForChange.setRemainingSum(newRemSum);
            mark = true;
        }
        if (dpercent != -101) {
            debtForChange.setPercent(dpercent);
            mark = true;
        }
        if (!purpose.equals("0")) {
            debtForChange.setPercentForInitialAm(percentForInitialAm);
            mark = true;
        }
        if (mark) {
            if (dpercent == -101) dpercent = 0;
            debtService.updateDebt(debtForChange);
            debtService.addDebt(new Debt(dbUser, damount, date, description, percentForInitialAm, dpercent, debtId));
            return "redirect:/";
        } else {
            String errorStr = "No debt changing has been detected, operation hasn't been implemented";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
    }

    private String returnResPage(boolean res, Model model) {
        String errorStr;
        if (res) return "redirect:/";
        else {
            errorStr = "Purpose error. Try again";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
    }

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
