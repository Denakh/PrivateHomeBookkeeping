package mainpackage;

import mainpackage.entities.allocationofprofits.AllocationOfProfits;
import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRate;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRateService;
import mainpackage.entities.income.GeneralIncome;
import mainpackage.entities.income.GeneralIncomeService;
import mainpackage.entities.users.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //@Bean
    public CommandLineRunner demo(final UserService userService, final GeneralIncomeService generalIncomeService,
                                  final AllocationOfProfitsService allocationOfProfitsService,
                                  final CurrentExpensesRateService currentExpensesRateService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                //userService.addUser(new CustomUser("admin", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.ADMIN));
                //userService.addUser(new CustomUser("user", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.USER));
                generalIncomeService.addGeneralIncome(new GeneralIncome(100, new Date(), (byte) 6, 3000, 0));
                allocationOfProfitsService.addAllocationOfProfits(new AllocationOfProfits(10.0, 10.0, 30.0,
                        30.0, 10.0, 10.0));
                currentExpensesRateService.addCurrentExpensesRate(new CurrentExpensesRate(8000, 8000, 8000, 8000,
                                7000, 6000, 6000, 6000, 6000, 6000, 7000, 8000));
            }
        };
    }
}