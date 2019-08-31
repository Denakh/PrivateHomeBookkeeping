package mainpackage;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRate;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRateService;
import mainpackage.entities.debt.Debt;
import mainpackage.entities.debt.DebtService;
import mainpackage.entities.mainfinancestatistic.FinancialCondition;
import mainpackage.entities.mainfinancestatistic.MainFinanceStatistic;
import mainpackage.entities.mainfinancestatistic.MainFinanceStatisticService;
import mainpackage.entities.users.CustomUser;
import mainpackage.entities.users.UserRole;
import mainpackage.entities.users.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(final UserService userService, final MainFinanceStatisticService mainFinanceStatisticService,
                                  final AllocationOfProfitsService allocationOfProfitsService,
                                  final CurrentExpensesRateService currentExpensesRateService,
                                  final DebtService debtService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                Date date = new Date();
                CustomUser user = new CustomUser("user", "3ca48ee9cd5fb6d0fe5137c4576213cea9749115", UserRole.USER);
                userService.addUser(new CustomUser("admin", "28e1090f163cbc5a648a08a4c93934fe23312e17", UserRole.ADMIN));
                userService.addUser(user);
            }
        };
    }
}