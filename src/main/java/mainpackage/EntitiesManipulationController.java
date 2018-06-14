package mainpackage;

import mainpackage.entities.charity.Charity;
import mainpackage.entities.charity.CharityService;
import mainpackage.entities.health.Health;
import mainpackage.entities.health.HealthService;
import mainpackage.entities.income.Income;
import mainpackage.entities.income.IncomeService;
import mainpackage.entities.users.CustomUser;
import mainpackage.entities.users.UserRole;
import mainpackage.entities.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

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
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();
        CustomUser dbUser = userService.getUserByLogin(login);
        Date date = new Date();

        Income income = new Income(dbUser, damount, date, description, purpose);
        incomeService.addIncome(income);

        switch (purpose) {
            case "charity":
                Charity c = charityService.findLastEntry();
                charityService.addCharity(new Charity(dbUser, damount, date, description, c.getAmount()+damount));
                break;
            case "health":
                healthService.addHealth(new Health(dbUser, damount, date, description));
                break;
            default:
                errorStr = "Purpose error. Try again";
                model.addAttribute("error_message", errorStr);
                return "/input_error";
        }

        /*
        switch (purpose) {
            case "charity":
                showFlats(conn, sc, 1);
                break;
            case "2":
                showFlats(conn, sc, 2);
                break;
            case "3":
                showFlats(conn, sc, 3);
                ;
                break;
            case "4":
                System.out.println("Program has been finished");
                return;
            default:
                System.out.println("Command doesn't exist");
                break;
        }

        /*
        CustomUser dbUser = new CustomUser(login, passHash, UserRole.USER, email, phone);
        userService.addUser(dbUser);
       /*
       Amount, hrn: <input type="text" name="amount"><br>
    Description: <input type="text" name="description"><br>
    Purpose:
    <br/><input type="radio" name="purpose" value="general" /> general
    <br/><input type="radio" name="purpose" value="charity" /> charity
    <br/><input type="radio" name="purpose" value="health" /> health
    <br/><input type="radio" name="purpose" value="kids_and_pets" /> kids and pats
    <br/><input type="radio" name="purpose" value="other_capoutlays" /> other capital outlays
    <br/><input type="radio" name="purpose" value="recreation" /> recreation
    <br/><input type="radio" name="purpose" value="reserve" /> reserve
        */


        return "redirect:/";
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

}
