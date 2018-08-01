package mainpackage;

import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.charity.Charity;
import mainpackage.entities.charity.CharityService;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRateService;
import mainpackage.entities.debt.Debt;
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
import mainpackage.entities.income.Income;
import mainpackage.entities.users.CustomUser;
import mainpackage.entities.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class AnalysisController {

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

    @RequestMapping("/current_exp_calculation")
    public String dataGetting() {
        return "current_exp_calculation";
    }

    @RequestMapping("/current_exp_calculation_execute")
    public String incomeFixationExecute(@RequestParam String amount,
                                        Model model) {
        double dfactAmount;
        String errorStr = "";
        try {
            dfactAmount = Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            errorStr = "Number format error. Try again";
            model.addAttribute("error_message", errorStr);
            return "/input_error";
        }
        CustomUser dbUser = this.getCurrentUser();
        Date date = new Date();
        List<Debt> effectiveDebtsList = new ArrayList<>();
        effectiveDebtsList = debtService.findEffectiveDebtsList(dbUser);
        double debtsTotAmount = 0;
        GregorianCalendar gcalendar = (GregorianCalendar) GregorianCalendar.getInstance();
        gcalendar.setTime(date);
        byte curMonthNumber = (byte) (gcalendar.get(Calendar.MONTH) + 1);
        byte curDayNumber = (byte) (gcalendar.get(Calendar.DAY_OF_MONTH));
        byte prevMonthNumber = (byte) (curMonthNumber - 1);
        if (curMonthNumber == 0) prevMonthNumber = 12;
        if (!effectiveDebtsList.isEmpty()) {
            for (Debt d : effectiveDebtsList) debtsTotAmount += d.getAmount();
        }
        double totalCurExp = charityService.findLastEntry(dbUser).getAmount() +
                healthService.findLastEntry(dbUser).getAmount() + kidsAndPetsService.findLastEntry(dbUser).getAmount() +
                otherCapitalOutlaysService.findLastEntry(dbUser).getAmount() +
                recreationService.findLastEntry(dbUser).getAmount() + reserveService.findLastEntry(dbUser).getAmount() +
                debtsTotAmount + getCurrentExpRate(dbUser, curMonthNumber)*(1 - (curDayNumber/30)) - dfactAmount +
                getCurrentExpRate(dbUser, prevMonthNumber);

        /*
        Income income = new Income(dbUser, damount, date, description, purpose);
        if (purpose.equals("general")) {
            this.entitiesAddFromGeneral(dbUser, damount, date, description, income);
            return "redirect:/";
        }
        incomeService.addIncome(income);
        double am = 0;
        boolean res = this.entitiesAdd(purpose, dbUser, damount, date, description, am);
        return this.returnResPage(res, model);
        */
        return "/current_exp_calculation_result";
    }

    private double getCurrentExpRate(CustomUser user, Byte month) {
        switch (month) {
            case 1:
                return currentExpensesRateService.findLastEntry(user).getM1am();
            case 2:
                return currentExpensesRateService.findLastEntry(user).getM2am();
            case 3:
                return currentExpensesRateService.findLastEntry(user).getM3am();
            case 4:
                return currentExpensesRateService.findLastEntry(user).getM4am();
            case 5:
                return currentExpensesRateService.findLastEntry(user).getM5am();
            case 6:
                return currentExpensesRateService.findLastEntry(user).getM6am();
            case 7:
                return currentExpensesRateService.findLastEntry(user).getM7am();
            case 8:
                return currentExpensesRateService.findLastEntry(user).getM8am();
            case 9:
                return currentExpensesRateService.findLastEntry(user).getM9am();
            case 10:
                return currentExpensesRateService.findLastEntry(user).getM10am();
            case 11:
                return currentExpensesRateService.findLastEntry(user).getM11am();
            case 12:
                return currentExpensesRateService.findLastEntry(user).getM12am();
        }
        return 0;
    }

    private CustomUser getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();
        return userService.getUserByLogin(login);
    }

}
