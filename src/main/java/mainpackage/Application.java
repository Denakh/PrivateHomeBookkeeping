package mainpackage;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRate;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRateService;
import mainpackage.entities.debt.Debt;
import mainpackage.entities.debt.DebtService;
import mainpackage.entities.income.GeneralIncome;
import mainpackage.entities.income.GeneralIncomeService;
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

    //@Bean
    public CommandLineRunner demo(final UserService userService, final GeneralIncomeService generalIncomeService,
                                  final AllocationOfProfitsService allocationOfProfitsService,
                                  final CurrentExpensesRateService currentExpensesRateService,
                                  final DebtService debtService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                Date date = new Date();
                CustomUser user = new CustomUser("user", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.USER);
                userService.addUser(new CustomUser("admin", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.ADMIN));
                userService.addUser(user);
                generalIncomeService.addGeneralIncome(new GeneralIncome(user,100, date, (byte) 6, 3000, 0));
                allocationOfProfitsService.addAllocationOfProfits(new AllocationOfProfits(user, date, 10.0, 10.0, 30.0,
                        30.0, 10.0, 10.0));
                currentExpensesRateService.addCurrentExpensesRate(new CurrentExpensesRate(user, date,8000, 8000, 8000, 8000,
                        7000, 6000, 6000, 6000, 6000, 6000, 7000, 8000));
                debtService.addDebt(new Debt(user, 1000, date, "test", false, 10.1, 1000));
            }
        };
    }
}