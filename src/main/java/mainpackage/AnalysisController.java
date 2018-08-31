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

    @RequestMapping("/financial_analysis_execute")
    public String finAnalysisExe(@RequestParam(defaultValue = "0") String per,
                                 @RequestParam(defaultValue = "0") String periodicity,
                                 Model model) {
        if (periodicity.equals("0") || per.equals("0")) return this.errorEmptyStr(model);
        CustomUser dbUser = this.getCurrentUser();
        List<MainFinanceStatistic> mfsList = mainFinanceStatisticService.findAllEntries(dbUser);
        int mfsEntriesQ = mfsList.size();
        if (mfsEntriesQ < 2) mfsEntriesQ = 0;
        if (mfsEntriesQ == 0) return this.errorDataLacking(model);
        List<MainFinanceStatistic> mfsListEf = this.getMFSEffList(mfsList, per, periodicity, mfsEntriesQ);
        double overallBalanceWDFLast = mfsList.get(mfsList.size() - 1).getOverallBalanceWD();
        Date date = new Date();
        List<Debt> effectiveDebtsList = debtService.findEffectiveDebtsList(dbUser);
        double debtsTotAmount = 0;
        GregorianCalendar gcalendar = (GregorianCalendar) GregorianCalendar.getInstance();
        gcalendar.setTime(date);
        byte curMonthNumber = (byte) (gcalendar.get(Calendar.MONTH) + 1);
        byte curDayNumber = (byte) (gcalendar.get(Calendar.DAY_OF_MONTH));
        if (!effectiveDebtsList.isEmpty()) {
            for (Debt d : effectiveDebtsList) {
                if (d.getRemainingSum() > 0) debtsTotAmount += d.getRemainingSum();
            }
        }
        OverallBalance obCulc = getCalculatedBalance(dbUser, curMonthNumber, curDayNumber,
                debtsTotAmount, date, effectiveDebtsList);
        double overallBalanceWDCLast = obCulc.getBalanceWithDep();
        this.finAnalysisExeFin(mfsList, mfsListEf, dbUser, overallBalanceWDFLast, overallBalanceWDCLast, model);
        return "/financial_analysis_results";
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


    private List<MainFinanceStatistic> getMFSEffList(List<MainFinanceStatistic> mfsList, String per, String periodicity,
                                                     int mfsEntriesQ) {
        List<MainFinanceStatistic> mfsListEf = new ArrayList<>();
        int periodQ = mfsEntriesQ;
        int periodicityQ = 1;
        if (per.equals("year") && mfsEntriesQ > 12) periodQ = 12;
        switch (periodicity) {
            case "3_months":
                periodicityQ = 3;
                break;
            case "6_months":
                periodicityQ = 6;
                break;
            case "year":
                periodicityQ = 12;
                break;
        }
        int pQ = periodQ / periodicityQ;
        for (int i = mfsEntriesQ - periodQ; i < mfsEntriesQ; i += 1) mfsListEf.add(mfsList.get(i));
        if (periodicityQ > 1) mfsListEf = this.getMFSPerPeriodList(mfsListEf, periodicityQ, pQ);
        return mfsListEf;
    }

    private List<MainFinanceStatistic> getMFSPerPeriodList(List<MainFinanceStatistic> mfsListEf, int periodicityQ, int pQ) {
        List<MainFinanceStatistic> mfsListEfnew = new ArrayList<>();
        int servV = mfsListEf.size() - periodicityQ * pQ;
        for (int i = 0; i < pQ; i += 1) {
            byte month = 0;
            int year = 0;
            double totalIncome = 0;
            double totalExpenses = 0;
            double currentExpenses = 0;
            double passiveDebtsSum = 0;
            double overallBalanceWDSum = 0;
            double curExpFactStandDifSum = 0;
            byte monthLast = 0;
            int yearLast = 0;
            for (int j = servV + i * periodicityQ; j < servV + (i + 1) * periodicityQ; j += 1) {
                MainFinanceStatistic mfsEf = mfsListEf.get(j);
                if (j == servV + i * periodicityQ) month = mfsEf.getMonth();
                if (j == servV + i * periodicityQ) year = mfsEf.getYear();
                if (j == servV + (i + 1) * periodicityQ - 1) monthLast = mfsEf.getMonth();
                if (j == servV + (i + 1) * periodicityQ - 1) yearLast = mfsEf.getYear();
                totalIncome += mfsEf.getTotalIncome();
                totalExpenses += mfsEf.getTotalExpenses();
                currentExpenses += mfsEf.getCurrentExpenses();
                passiveDebtsSum += mfsEf.getPassiveDebts();
                overallBalanceWDSum += mfsEf.getOverallBalanceWD();
                curExpFactStandDifSum += mfsEf.getCurExpFactStandDif();
            }
            MainFinanceStatistic mfsEfnew = this.getMainFinanceStatisticEfnew(month, year, totalIncome, totalExpenses,
                    currentExpenses, passiveDebtsSum, periodicityQ, overallBalanceWDSum, curExpFactStandDifSum, monthLast, yearLast);
            mfsListEfnew.add(mfsEfnew);
        }
        return mfsListEfnew;
    }

    private MainFinanceStatistic getMainFinanceStatisticEfnew(byte month, int year, double totalIncome, double totalExpenses,
                                                              double currentExpenses, double passiveDebtsSum, double periodicityQ,
                                                              double overallBalanceWDSum, double curExpFactStandDifSum,
                                                              byte monthLast, int yearLast) {
        MainFinanceStatistic mfsEfnew = new MainFinanceStatistic(month, year, totalIncome, totalExpenses, totalExpenses / totalIncome,
                currentExpenses, currentExpenses / totalIncome, passiveDebtsSum / periodicityQ,
                overallBalanceWDSum / periodicityQ, passiveDebtsSum / overallBalanceWDSum, curExpFactStandDifSum / periodicityQ,
                this.getFCByCurExpansesCover(currentExpenses / totalIncome), this.getFCBypassDebtsToOBRatio(passiveDebtsSum / overallBalanceWDSum), monthLast, yearLast);
        List<FinancialCondition> fcl = new ArrayList<>();
        fcl.add(mfsEfnew.getFcByCurExpCover());
        fcl.add(mfsEfnew.getFcByDebtsToOBRatio());
        mfsEfnew.setFcResult(this.getResultFinCondition(fcl));
        return mfsEfnew;
    }

    private void finAnalysisExeFin(List<MainFinanceStatistic> mfsList, List<MainFinanceStatistic> mfsListEf,
                                   CustomUser dbUser, double overallBalanceWDFLast, double overallBalanceWDCLast,
                                   Model model) {
        double currentExpensesSum = 0;
        double totalIncomeSum = 0;
        double totalExpensesSum = 0;
        double passDebtsToOBRatio = 0;
        double curExpFactStandDifSum = 0;
        double curExpRateSum = 0;
        int firstSt = mfsList.size() - 3;
        if (firstSt < 0) firstSt = 0;
        for (int i = firstSt; i < mfsList.size(); i += 1) {
            currentExpensesSum += mfsList.get(i).getCurrentExpenses();
            totalIncomeSum += mfsList.get(i).getTotalIncome();
            totalExpensesSum += mfsList.get(i).getTotalExpenses();
            curExpFactStandDifSum += mfsList.get(i).getCurExpFactStandDif();
            byte monthNum = mfsList.get(i).getMonth();
            curExpRateSum += getCurrentExpRate(dbUser, monthNum);
            if (i == mfsList.size() - 1) passDebtsToOBRatio = mfsList.get(i).getPassDebtsToOBRatio();
        }
        double curExpensesCoverByIncome = currentExpensesSum / totalIncomeSum;
        double expToIncRatio = totalExpensesSum / totalIncomeSum;
        double relationalCEFactStandDif = 100 * curExpFactStandDifSum / curExpRateSum;
        double recCERchanging = curExpFactStandDifSum / 3;
        FinancialCondition fcByCurExpansesCover = this.getFCByCurExpansesCover(curExpensesCoverByIncome);
        FinancialCondition fcByPassDebtsToOBRatio = this.getFCBypassDebtsToOBRatio(passDebtsToOBRatio);
        List<FinancialCondition> fcl = new ArrayList<>();
        fcl.add(fcByCurExpansesCover);
        fcl.add(fcByPassDebtsToOBRatio);
        FinancialCondition fcRes = this.getResultFinCondition(fcl);
        String advices = this.getAdvices(curExpensesCoverByIncome, passDebtsToOBRatio, relationalCEFactStandDif,
                recCERchanging);
        this.finAnalysisExeModAddAtt(mfsListEf, overallBalanceWDFLast, overallBalanceWDCLast, curExpensesCoverByIncome,
                expToIncRatio, passDebtsToOBRatio, relationalCEFactStandDif, fcRes, advices, model);
    }

    private void finAnalysisExeModAddAtt(List<MainFinanceStatistic> mfsListEf, double overallBalanceWDFLast,
                                         double overallBalanceWDCLast, double curExpensesCoverByIncome,
                                         double expToIncRatio, double passDebtsToOBRatio, double relationalCEFactStandDif,
                                         FinancialCondition fcRes, String advices, Model model) {
        model.addAttribute("mfsListEf", mfsListEf);
        model.addAttribute("overallBalanceWDFLast", overallBalanceWDFLast);
        model.addAttribute("overallBalanceWDCLast", overallBalanceWDCLast);
        model.addAttribute("curExpensesCoverByIncome", curExpensesCoverByIncome);
        model.addAttribute("expToIncRatio", expToIncRatio);
        model.addAttribute("passDebtsToOBRatio", passDebtsToOBRatio);
        model.addAttribute("relationalCEFactStandDif", relationalCEFactStandDif);
        model.addAttribute("fcRes", fcRes);
        model.addAttribute("advices", advices);
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
        OtherCapitalOutlays otherCapitalOutlays = otherCapitalOutlaysService.findLastEntry(dbUser);
        double currentExpRate = getCurrentExpRate(dbUser, curMonthNumber);
        double currentExpRatePrev = getCurrentExpRate(dbUser, prevMonthNumber);
        double noCurExpCoverAm = this.getNoCurExpCoverAm(dbUser, curMonthNumber, currentExpRate);
        double genIncomeAmountForCurExp = this.getGenIncomeAmountForCurExp(dbUser, curMonthNumber);
        if (charityService.findLastEntry(dbUser) != null) charityAm = charityService.findLastEntry(dbUser).getAmount();
        if (healthService.findLastEntry(dbUser) != null) healthAm = healthService.findLastEntry(dbUser).getAmount();
        if (kidsAndPetsService.findLastEntry(dbUser) != null)
            kidsAndPetsAm = kidsAndPetsService.findLastEntry(dbUser).getAmount();
        if (otherCapitalOutlays != null) otherCapitalOutlaysAm = otherCapitalOutlays.getAmount();
        if (recreationService.findLastEntry(dbUser) != null)
            recreationAm = recreationService.findLastEntry(dbUser).getAmount();
        if (reserveService.findLastEntry(dbUser) != null) reserveAm = reserveService.findLastEntry(dbUser).getAmount();
        double dif = charityAm + healthAm + kidsAndPetsAm + otherCapitalOutlaysAm + recreationAm + reserveAm + debtsTotAmount +
                currentExpRate * (1 - (1.0 * curDayNumber / 30.417)) + noCurExpCoverAm + genIncomeAmountForCurExp - dfactAmount;
        double totalCurExp = currentExpRatePrev + dif;
        CurrentExpenses ce = new CurrentExpenses(dbUser, totalCurExp, currentExpRatePrev, dif, prevMonthNumber, date);
        currentExpensesService.addCurrentExpenses(ce);
        otherCapitalOutlaysService.addOtherCapitalOutlays(new OtherCapitalOutlays(dbUser, -dif, date,
                "current expenses excess compensation", otherCapitalOutlaysAm - dif));
        model.addAttribute("calculation_result", totalCurExp);
        model.addAttribute("difference", dif);
        return ce;
    }

    private double getGenIncomeAmountForCurExp(CustomUser dbUser, byte curMonthNumber) {
        double genIncomeAmountForCurExp = 0;
        GeneralIncome gi = generalIncomeService.findLastEntry(dbUser);
        if (gi != null) {
            if (gi.getMonthNumber() > curMonthNumber || (curMonthNumber >= 11 && gi.getMonthNumber() <= 2))
                genIncomeAmountForCurExp = gi.getAccumulation() - gi.getExcessForAllocation();
        }
        return genIncomeAmountForCurExp;
    }

    private double getNoCurExpCoverAm(CustomUser dbUser, byte curMonthNumber, double currentExpRate) {
        double noCurExpCoverAm = 0;
        GeneralIncome gi = generalIncomeService.findLastEntry(dbUser);
        if (gi != null) {
            if (gi.getMonthNumber() <= curMonthNumber || (gi.getMonthNumber() >= 11 && curMonthNumber <= 2))
                noCurExpCoverAm = gi.getAccumulation() - currentExpRate;
        }
        return noCurExpCoverAm;
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
        double currentExpRate = getCurrentExpRate(dbUser, curMonthNumber);
        double noCurExpCoverAm = this.getNoCurExpCoverAm(dbUser, curMonthNumber, currentExpRate);
        double genIncomeAmountForCurExp = this.getGenIncomeAmountForCurExp(dbUser, curMonthNumber);
        if (charityService.findLastEntry(dbUser) != null) charityAm = charityService.findLastEntry(dbUser).getAmount();
        if (healthService.findLastEntry(dbUser) != null) healthAm = healthService.findLastEntry(dbUser).getAmount();
        if (kidsAndPetsService.findLastEntry(dbUser) != null)
            kidsAndPetsAm = kidsAndPetsService.findLastEntry(dbUser).getAmount();
        if (otherCapitalOutlaysService.findLastEntry(dbUser) != null)
            otherCapitalOutlaysAm = otherCapitalOutlaysService.findLastEntry(dbUser).getAmount();
        if (recreationService.findLastEntry(dbUser) != null)
            recreationAm = recreationService.findLastEntry(dbUser).getAmount();
        if (reserveService.findLastEntry(dbUser) != null) reserveAm = reserveService.findLastEntry(dbUser).getAmount();
        if (!effectiveDebtsList.isEmpty()) {
            for (Debt d : effectiveDebtsList) {
                if (d.getAmount() < 0) depositsAm += -d.getAmount();
            }
        }
        calcBalanceLiq = charityAm + healthAm + kidsAndPetsAm + otherCapitalOutlaysAm + recreationAm + reserveAm +
                debtsTotAmount + currentExpRate * (1 - (1.0 * curDayNumber / 30.417)) + noCurExpCoverAm + genIncomeAmountForCurExp;
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
        mfs.setYear(prevDateYear);
        mfs.setMonthLast(mfs.getMonth());
        mfs.setYearLast(mfs.getYear());
        List<FinancialCondition> fcl = new ArrayList<>();
        fcl.add(mfs.getFcByCurExpCover());
        fcl.add(mfs.getFcByDebtsToOBRatio());
        mfs.setFcResult(this.getResultFinCondition(fcl));
        mainFinanceStatisticService.addMainFinanceStatistic(mfs);
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
        FinancialCondition fc = this.getFCByCurExpansesCover(expCover);
        mfs.setCurrentExpenses(totalCurExp);
        mfs.setCurExpensesCoverByIncome(expCover);
        mfs.setFcByCurExpCover(fc);
        return mfs;
    }

    private FinancialCondition getFCByCurExpansesCover(double expCover) {
        FinancialCondition fc;
        if (expCover < 0.50) fc = FinancialCondition.EXCELLENT;
        else if (expCover >= 0.50 && expCover < 0.75) fc = FinancialCondition.GOOD;
        else if (expCover >= 0.75 && expCover < 1.00) fc = FinancialCondition.SATISFACTORY;
        else if (expCover >= 1.00 && expCover < 2.00) fc = FinancialCondition.UNSATISFACTORY;
        else fc = FinancialCondition.DANGEROUS;
        return fc;
    }

    private MainFinanceStatistic getPassDebtsToOBRatio(double debtsTotAmount, MainFinanceStatistic mfs,
                                                       OverallBalance obCur) {
        double passDebtsToOBRatio = debtsTotAmount / obCur.getBalanceWithDep();
        FinancialCondition fc = this.getFCBypassDebtsToOBRatio(passDebtsToOBRatio);
        mfs.setPassiveDebts(debtsTotAmount);
        mfs.setOverallBalanceWD(obCur.getBalanceWithDep());
        mfs.setFcByDebtsToOBRatio(fc);
        return mfs;
    }

    private FinancialCondition getFCBypassDebtsToOBRatio(double passDebtsToOBRatio) {
        FinancialCondition fc;
        if (passDebtsToOBRatio == 0.00) fc = FinancialCondition.EXCELLENT;
        else if (passDebtsToOBRatio > 0.00 && passDebtsToOBRatio < 0.25) fc = FinancialCondition.GOOD;
        else if (passDebtsToOBRatio >= 0.25 && passDebtsToOBRatio < 0.50) fc = FinancialCondition.SATISFACTORY;
        else if (passDebtsToOBRatio >= 0.50 && passDebtsToOBRatio < 0.75) fc = FinancialCondition.UNSATISFACTORY;
        else fc = FinancialCondition.DANGEROUS;
        return fc;
    }

    private String errorEmptyStr(Model model) {
        String errorStr = "Not choose variant in list. Try again";
        model.addAttribute("error_message", errorStr);
        return "/input_error";
    }

    private String errorDataLacking(Model model) {
        String errorStr = "You have to have at least 2 months of home finance data accumulation " +
                "for correct finance analysis getting";
        model.addAttribute("error_message", errorStr);
        return "/input_error";
    }

    private String getAdvices(double curExpensesCoverByIncome, double passDebtsToOBRatio, double relationalCEFactStandDif,
                              double recCERchanging) {
        FinancialCondition fcByCurExpansesCover = this.getFCByCurExpansesCover(curExpensesCoverByIncome);
        FinancialCondition fcByPassDebtsToOBRatio = this.getFCBypassDebtsToOBRatio(passDebtsToOBRatio);
        String advCase11 = "It is necessary to minimize expenses and urgently seek new sources of income. ";
        String advCase12 = "It is necessary to increase income and/or reduce current expenses. ";
        String advCase13 = "It is recommended to increase income and/or reduce current expenses. ";
        String advCase152425 = "It is recommended to make long-term savings (for investment or expensive purchases). ";
        String advCase21 = "It is necessary to restructure debts (extend the payment and/or partially write off), " +
                "additional debts can be taken only in extreme cases. ";
        String advCase22 = "It is necessary to avoid taking additional debts. ";
        String advCase23 = "It is recommended not to lend extra money. ";
        String advCase31 = "It is recommended to increase the rate of current expenses: ";
        String advCase32 = "It is recommended to reduce the rate of current expenses: ";
        int recCERchangingInt = (int) recCERchanging;
        return this.getAdvicesFin(fcByCurExpansesCover, fcByPassDebtsToOBRatio, relationalCEFactStandDif, recCERchangingInt,
                advCase11, advCase12, advCase13, advCase152425, advCase21, advCase22, advCase23, advCase31, advCase32);
    }

    private String getAdvicesFin(FinancialCondition fcByCurExpansesCover, FinancialCondition fcByPassDebtsToOBRatio,
                                 double relationalCEFactStandDif, int recCERchanging, String advCase11, String advCase12,
                                 String advCase13, String advCase152425, String advCase21, String advCase22,
                                 String advCase23, String advCase31, String advCase32) {
        String advices = "No advices";
        if (fcByPassDebtsToOBRatio == FinancialCondition.DANGEROUS) {
            advices = advCase21 + advCase11;
            if (relationalCEFactStandDif < -10.0) advices = advices + advCase32 + recCERchanging + "";
            return advices;
        }
        if (fcByPassDebtsToOBRatio == FinancialCondition.UNSATISFACTORY) {
            if (fcByCurExpansesCover == FinancialCondition.DANGEROUS) advices = advCase22 + advCase11;
            else advices = advCase22 + " " + advCase12;
            if (relationalCEFactStandDif < -10.0) advices = advices + advCase32 + recCERchanging + "";
            return advices;
        }
        if (fcByPassDebtsToOBRatio == FinancialCondition.SATISFACTORY) {
            if (fcByCurExpansesCover == FinancialCondition.DANGEROUS) advices = advCase23 + advCase11;
            else if (fcByCurExpansesCover == FinancialCondition.UNSATISFACTORY) advices = advCase23 + advCase12;
            else advices = advCase23 + advCase13;
            if (relationalCEFactStandDif < -10.0) advices = advices + advCase32 + recCERchanging + "";
            return advices;
        }
        if (fcByCurExpansesCover == FinancialCondition.EXCELLENT) {
            advices = advCase152425;
            if (relationalCEFactStandDif > 10.0) advices = advices + advCase31 + recCERchanging + "";
            if (relationalCEFactStandDif < -10.0) advices = advices + advCase32 + recCERchanging + "";
            return advices;
        }
        if (relationalCEFactStandDif > 10.0) advices = advCase31 + recCERchanging + "";
        if (relationalCEFactStandDif < -10.0) advices = advCase32 + recCERchanging + "";
        return advices;
    }

    private FinancialCondition getResultFinCondition(List<FinancialCondition> fcl) {
        FinancialCondition worstFC = fcl.get(0);
        for (FinancialCondition fc : fcl) {
            if (fc.ordinal() > worstFC.ordinal()) worstFC = fc;
        }
        return worstFC;
    }

}
