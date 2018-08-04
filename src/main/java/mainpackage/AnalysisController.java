package mainpackage;

import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.charity.Charity;
import mainpackage.entities.charity.CharityService;
import mainpackage.entities.currentexpenses.CurrentExpenses;
import mainpackage.entities.currentexpenses.CurrentExpensesService;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRate;
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
    @Autowired
    private CurrentExpensesService currentExpensesService;

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
            errorStr = "Number format error. " + "Try again";
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
        if (prevMonthNumber == 0) prevMonthNumber = 12;
        if (!effectiveDebtsList.isEmpty()) {
            for (Debt d : effectiveDebtsList) debtsTotAmount += d.getAmount();
        }
        this.currentExpensesCalc(dbUser, curMonthNumber, prevMonthNumber, curDayNumber, debtsTotAmount,
                dfactAmount, date, model);
        List<Debt> efDebtsList = debtService.findEffectiveDebtsList(dbUser);
        if (efDebtsList != null || !efDebtsList.isEmpty()) this.accruedInterest(efDebtsList, dbUser, date);
        return "/current_exp_calculation_result";
    }

    private double getCurrentExpRate(CustomUser user, Byte month) {
        CurrentExpensesRate cer = currentExpensesRateService.findLastEntry(user);
        if (cer != null) {
            switch (month) {
                case 1:
                    return cer.getM1am();
                case 2:
                    return cer.getM2am();
                case 3:
                    return cer.getM3am();
                case 4:
                    return cer.getM4am();
                case 5:
                    return cer.getM5am();
                case 6:
                    return cer.getM6am();
                case 7:
                    return cer.getM7am();
                case 8:
                    return cer.getM8am();
                case 9:
                    return cer.getM9am();
                case 10:
                    return cer.getM10am();
                case 11:
                    return cer.getM11am();
                case 12:
                    return cer.getM12am();
            }
        }
        return 0;
    }

    private void currentExpensesCalc(CustomUser dbUser, byte curMonthNumber, byte prevMonthNumber, byte curDayNumber,
                                     double debtsTotAmount, double dfactAmount, Date date, Model model) {
        double charityAm = 0;
        double healthAm = 0;
        double kidsAndPetsAm = 0;
        double otherCapitalOutlaysAm = 0;
        double recreationAm = 0;
        double reserveAm = 0;
        if (charityService.findLastEntry(dbUser) != null) charityAm = charityService.findLastEntry(dbUser).getAmount();
        if (healthService.findLastEntry(dbUser) != null) healthAm = healthService.findLastEntry(dbUser).getAmount();
        if (kidsAndPetsService.findLastEntry(dbUser) != null)
            kidsAndPetsAm = kidsAndPetsService.findLastEntry(dbUser).getAmount();
        if (otherCapitalOutlaysService.findLastEntry(dbUser) != null)
            otherCapitalOutlaysAm = otherCapitalOutlaysService.findLastEntry(dbUser).getAmount();
        if (recreationService.findLastEntry(dbUser) != null)
            recreationAm = recreationService.findLastEntry(dbUser).getAmount();
        if (reserveService.findLastEntry(dbUser) != null) reserveAm = reserveService.findLastEntry(dbUser).getAmount();
        double currentExpRate = getCurrentExpRate(dbUser, curMonthNumber);
        double currentExpRatePrev = getCurrentExpRate(dbUser, prevMonthNumber);
        double dif = charityAm + healthAm + kidsAndPetsAm + otherCapitalOutlaysAm + recreationAm + reserveAm +
                debtsTotAmount + currentExpRate * (1 - (1.0 * curDayNumber / 30)) - dfactAmount;
        double totalCurExp = currentExpRatePrev + dif;
        currentExpensesService.addCurrentExpenses(new CurrentExpenses(dbUser, totalCurExp, currentExpRatePrev,
                prevMonthNumber, date));
        model.addAttribute("calculation_result", totalCurExp);
        model.addAttribute("difference", dif);
    }

    private void accruedInterest(List<Debt> efDebtsList, CustomUser dbUser, Date date) {
        for (Debt d : efDebtsList) {
            if (d.getPercent() > 0) {
                double remSumCh = 0;
                if (d.isPercentForInitialAm()) {
                    remSumCh = d.getAmount() * 0.01 * d.getPercent();
                } else {
                    remSumCh = d.getRemainingSum() * 0.01 * d.getPercent();
                }
                d.setRemainingSum(d.getRemainingSum() + remSumCh);
                debtService.updateDebt(d);
                debtService.addDebt(new Debt(dbUser, remSumCh, date, "accrued interest", d.getId()));
            }
        }
    }

    private CustomUser getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();
        return userService.getUserByLogin(login);
    }


}
