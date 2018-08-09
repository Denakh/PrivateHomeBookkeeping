package mainpackage;

import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.charity.CharityService;
import mainpackage.entities.currentexpenses.CurrentExpenses;
import mainpackage.entities.currentexpenses.CurrentExpensesService;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRate;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRateService;
import mainpackage.entities.debt.Debt;
import mainpackage.entities.debt.DebtService;
import mainpackage.entities.health.HealthService;
import mainpackage.entities.income.GeneralIncome;
import mainpackage.entities.income.GeneralIncomeService;
import mainpackage.entities.income.Income;
import mainpackage.entities.income.IncomeService;
import mainpackage.entities.kidsandpets.KidsAndPetsService;
import mainpackage.entities.mainfinancestatistic.FinancialCondition;
import mainpackage.entities.mainfinancestatistic.MainFinanceStatistic;
import mainpackage.entities.mainfinancestatistic.MainFinanceStatisticService;
import mainpackage.entities.othercapitaloutlays.OtherCapitalOutlays;
import mainpackage.entities.othercapitaloutlays.OtherCapitalOutlaysService;
import mainpackage.entities.overallbalance.BalanceType;
import mainpackage.entities.overallbalance.OverallBalance;
import mainpackage.entities.overallbalance.OverallBalanceService;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Autowired
    private OverallBalanceService overallBalanceService;
    @Autowired
    private MainFinanceStatisticService mainFinanceStatisticService;

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
            for (Debt d : effectiveDebtsList) {
                if (d.getRemainingSum() > 0) debtsTotAmount += d.getRemainingSum();
            }
        }
        CurrentExpenses ce = this.currentExpensesCalc(dbUser, curMonthNumber, prevMonthNumber, curDayNumber, debtsTotAmount,
                dfactAmount, date, model);
        OverallBalance obnew = this.factualBalanceAdd(dbUser, date, dfactAmount, effectiveDebtsList);
        if (!effectiveDebtsList.isEmpty()) this.accruedInterest(effectiveDebtsList, dbUser, date);
        this.createMainFinStatEntity(dbUser, prevMonthNumber, curMonthNumber, debtsTotAmount, gcalendar, obnew, ce);
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

    private CurrentExpenses currentExpensesCalc(CustomUser dbUser, byte curMonthNumber, byte prevMonthNumber, byte curDayNumber,
                                                double debtsTotAmount, double dfactAmount, Date date, Model model) {
        double charityAm = 0;
        double healthAm = 0;
        double kidsAndPetsAm = 0;
        double otherCapitalOutlaysAm = 0;
        double recreationAm = 0;
        double reserveAm = 0;
        double noCurExpCoverAm = 0;
        OtherCapitalOutlays otherCapitalOutlays = otherCapitalOutlaysService.findLastEntry(dbUser);
        GeneralIncome gi = generalIncomeService.findLastEntry(dbUser);
        double currentExpRate = getCurrentExpRate(dbUser, curMonthNumber);
        double currentExpRatePrev = getCurrentExpRate(dbUser, prevMonthNumber);
        if (gi != null) {
            boolean dateCheck = gi.getDate().getTime() < date.getTime();
            if (gi.getMonthNumber() <= curMonthNumber || (gi.getMonthNumber() > curMonthNumber && dateCheck))
                noCurExpCoverAm = gi.getAccumulation() - currentExpRate;
        }
        if (charityService.findLastEntry(dbUser) != null) charityAm = charityService.findLastEntry(dbUser).getAmount();
        if (healthService.findLastEntry(dbUser) != null) healthAm = healthService.findLastEntry(dbUser).getAmount();
        if (kidsAndPetsService.findLastEntry(dbUser) != null) kidsAndPetsAm = kidsAndPetsService.findLastEntry(dbUser).getAmount();
        if (otherCapitalOutlays != null) otherCapitalOutlaysAm = otherCapitalOutlays.getAmount();
        if (recreationService.findLastEntry(dbUser) != null) recreationAm = recreationService.findLastEntry(dbUser).getAmount();
        if (reserveService.findLastEntry(dbUser) != null) reserveAm = reserveService.findLastEntry(dbUser).getAmount();
        double dif = charityAm + healthAm + kidsAndPetsAm + otherCapitalOutlaysAm + recreationAm + reserveAm +
                debtsTotAmount + currentExpRate * (1 - (1.0 * curDayNumber / 30.417)) + noCurExpCoverAm - dfactAmount;
        double totalCurExp = currentExpRatePrev + dif;
        CurrentExpenses ce = new CurrentExpenses(dbUser, totalCurExp, currentExpRatePrev, dif, prevMonthNumber, date);
        currentExpensesService.addCurrentExpenses(ce);
        otherCapitalOutlaysService.addOtherCapitalOutlays(new OtherCapitalOutlays(dbUser, -dif, date,
                "current expenses excess compensation", otherCapitalOutlaysAm - dif));
        model.addAttribute("calculation_result", totalCurExp);
        model.addAttribute("difference", dif);
        return ce;
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

    private OverallBalance factualBalanceAdd(CustomUser dbUser, Date date, double dfactAmount, List<Debt> effectiveDebtsList) {
        double depositsAm = 0;
        double obFactPrevLiq = 0;
        double obFactPrevWD = 0;
        boolean prevEnt = false;
        OverallBalance obFactNew = null;
        if (!effectiveDebtsList.isEmpty()) {
            for (Debt d : effectiveDebtsList) {
                if (d.getAmount() < 0) depositsAm += -d.getAmount();
            }
        }
        OverallBalance obFactPrev = overallBalanceService.findLastEntry(dbUser, BalanceType.FACTUAL);
        if (obFactPrev != null) {
            obFactPrevLiq = obFactPrev.getBalanceLiq();
            obFactPrevWD = obFactPrev.getBalanceWithDep();
            prevEnt = true;
        }
        if (prevEnt) obFactNew = new OverallBalance(dbUser, date, dfactAmount,
                dfactAmount + depositsAm, dfactAmount - obFactPrevLiq,
                dfactAmount + depositsAm - obFactPrevWD, BalanceType.FACTUAL);
        else obFactNew = new OverallBalance(dbUser, date, dfactAmount,
                dfactAmount + depositsAm, 0,
                0, BalanceType.FACTUAL);
        overallBalanceService.addOverallBalance(obFactNew);
        return obFactNew;
    }

    private OverallBalance getCalculatedBalance(CustomUser dbUser, byte curMonthNumber, byte curDayNumber,
                                                double debtsTotAmount, Date date, List<Debt> effectiveDebtsList) {
        double calcBalanceLiq = 0;
        double calcBalanceWithDep = 0;
        double charityAm = 0;
        double healthAm = 0;
        double kidsAndPetsAm = 0;
        double otherCapitalOutlaysAm = 0;
        double recreationAm = 0;
        double reserveAm = 0;
        double depositsAm = 0;
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
        if (!effectiveDebtsList.isEmpty()) {
            for (Debt d : effectiveDebtsList) {
                if (d.getAmount() < 0) depositsAm += -d.getAmount();
            }
        }
        calcBalanceLiq = charityAm + healthAm + kidsAndPetsAm + otherCapitalOutlaysAm + recreationAm + reserveAm +
                debtsTotAmount + currentExpRate * (1 - (1.0 * curDayNumber / 30.417));
        calcBalanceWithDep = calcBalanceLiq + depositsAm;
        return new OverallBalance(dbUser, date, calcBalanceLiq, calcBalanceWithDep, BalanceType.CALCULATED);
    }

    private void createMainFinStatEntity(CustomUser dbUser, byte prevMonthNumber, byte curMonthNumber, double debtsTotAmount,
                                         GregorianCalendar gcalendar, OverallBalance obCur, CurrentExpenses ce) {
        int curYear = gcalendar.get(Calendar.YEAR);
        int prevDateYear = curYear;
        if (curMonthNumber == 1) prevDateYear -= 1;
        String dateFromStr = "01." + prevMonthNumber + "." + prevDateYear + " 00:00:01";
        String dateToStr = "01." + curMonthNumber + "." + curYear + " 00:00:01";

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date dateFrom = null;
        Date dateTo = null;
        try {
            dateFrom = df.parse(dateFromStr);
            dateTo = df.parse(dateToStr);
        } catch (ParseException e) {
            e.getStackTrace();
        }
        MainFinanceStatistic mfs = new MainFinanceStatistic();
        mfs = this.getExpansesToIncomeRatio(dbUser, dateFrom, dateTo, mfs, obCur);
        mfs = this.getCurExpansesCoverByIncome(mfs, ce.getEstimatedAmount());
        mfs = this.getPassDebtsToOBRatio(debtsTotAmount, mfs, obCur);
        mfs.setCurExpFactStandDif(ce.getDifference());
        mfs.setMonth(prevMonthNumber);
        mfs.setUser(dbUser);
        mainFinanceStatisticService.addMainFinanceStatistic(mfs);
        //model.addAttribute("mfs", mfs);
    }

    private MainFinanceStatistic getExpansesToIncomeRatio(CustomUser dbUser, Date dateFrom, Date dateTo,
                                                          MainFinanceStatistic mfs, OverallBalance obCur) {
        double expIncRatio = 0;
        double totalIncome = 0;
        double totalExpenses = 0;
        List<Income> incomesByDate = incomeService.findEntriesBetweenDates(dbUser, dateFrom, dateTo);
        for (Income i : incomesByDate) totalIncome += i.getAmount();
        if (totalIncome == 0) totalIncome = 0.001;
        if (obCur != null) {
            totalExpenses = -obCur.getDifferenceWithDep() + totalIncome;
            expIncRatio = totalExpenses / totalIncome;
        }
        mfs.setTotalIncome(totalIncome);
        mfs.setTotalExpenses(totalExpenses);
        mfs.setExpToIncRatio(expIncRatio);
        return mfs;
    }

    private MainFinanceStatistic getCurExpansesCoverByIncome(MainFinanceStatistic mfs, double totalCurExp) {
        double totalIncome = mfs.getTotalIncome();
        double expCover = totalCurExp / totalIncome;
        FinancialCondition fc;
        if (expCover < 0.50) fc = FinancialCondition.EXCELLENT;
        else if (expCover >= 0.50 && expCover < 0.75) fc = FinancialCondition.GOOD;
        else if (expCover >= 0.75 && expCover < 1.00) fc = FinancialCondition.SATISFACTORY;
        else if (expCover >= 1.00 && expCover < 2.00) fc = FinancialCondition.UNSATISFACTORY;
        else fc = FinancialCondition.DANGEROUS;
        mfs.setCurrentExpenses(totalCurExp);
        mfs.setCurExpensesCoverByIncome(expCover);
        mfs.setFcByCurExpCover(fc);
        return mfs;
    }

    private MainFinanceStatistic getPassDebtsToOBRatio(double debtsTotAmount, MainFinanceStatistic mfs,
                                                       OverallBalance obCur) {
        double passDebtsToOBRatio = debtsTotAmount / obCur.getBalanceWithDep();
        FinancialCondition fc;
        if (passDebtsToOBRatio == 0.00) fc = FinancialCondition.EXCELLENT;
        else if (passDebtsToOBRatio > 0.00 && passDebtsToOBRatio < 0.25) fc = FinancialCondition.GOOD;
        else if (passDebtsToOBRatio >= 0.25 && passDebtsToOBRatio < 0.50) fc = FinancialCondition.SATISFACTORY;
        else if (passDebtsToOBRatio >= 0.50 && passDebtsToOBRatio < 0.75) fc = FinancialCondition.UNSATISFACTORY;
        else fc = FinancialCondition.DANGEROUS;
        mfs.setPassiveDebts(debtsTotAmount);
        mfs.setOverallBalanceWD(obCur.getBalanceWithDep());
        mfs.setFcByDebtsToOBRatio(fc);
        return mfs;
    }

}
/*
        OverallBalance obCur = null;
        List<OverallBalance> obCurList = overallBalanceService.findEntriesBetweenDates(dbUser, dateFrom, dateTo);
        List<Income> incomesByDate = incomeService.findEntriesBetweenDates(dbUser, dateFrom, dateTo);
        for (Income i : incomesByDate) totalIncome += i.getAmount();
        for (int i = 0; i < obCurList.size(); i += 1) {
            OverallBalance ob = obCurList.get(i);
            if (ob.getBalanceType() == BalanceType.FACTUAL) {
                obCur = ob;
                break;
            }
        }

        <br/>
<br/> id ${mfs.id}
<br/> user ${mfs.user}
<br/> month ${mfs.month}
<br/> totalIncome ${mfs.totalIncome}
<br/> totalExpenses ${mfs.totalExpenses}
<br/> expToIncRatio ${mfs.expToIncRatio}
<br/> currentExpenses ${mfs.currentExpenses}
<br/> curExpensesCoverByIncome ${mfs.curExpensesCoverByIncome}
<br/> passiveDebts ${mfs.passiveDebts}
<br/> overallBalanceWD ${mfs.overallBalanceWD}
<br/> passDebtsToOBRatio ${mfs.passDebtsToOBRatio}
<br/> curExpFactStandDif ${mfs.curExpFactStandDif}
<br/> fcByCurExpCover ${mfs.fcByCurExpCover}
<br/> fcByDebtsToOBRatio ${mfs.fcByDebtsToOBRatio}


        */