package mainpackage;

import mainpackage.entities.allocationofprofits.AllocationOfProfitsService;
import mainpackage.entities.currentexpenses.CurrentExpenses;
import mainpackage.entities.currentexpenses.CurrentExpensesService;
import mainpackage.entities.currentexpensesrate.CurrentExpensesRateService;
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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private CurrentExpensesService currentExpensesService;
    @Autowired
    private CurrentExpensesRateService currentExpensesRateService;
    @Autowired
    private AllocationOfProfitsService allocationOfProfitsService;

    @RequestMapping("/")
    public String index(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();
        CustomUser dbUser = userService.getUserByLogin(login);
        CurrentExpenses ceLast = currentExpensesService.findLastEntry(dbUser);
        boolean needCERenew = false;
        boolean needAllocOfProfSetup = false;
        boolean needCurExpRateSetup = false;
        Date date = new Date();
        GregorianCalendar gcalendar = (GregorianCalendar) GregorianCalendar.getInstance();
        gcalendar.setTime(date);
        byte prevMonthNumber = (byte) (gcalendar.get(Calendar.MONTH));
        if (prevMonthNumber == 0) prevMonthNumber = 12;
        if (ceLast != null) {
            if (prevMonthNumber > ceLast.getMonth() || date.getTime() - ceLast.getDate().getTime() > 2678400000L)
                needCERenew = true;
        } else needCERenew = true;
        if (allocationOfProfitsService.findLastEntry(dbUser) == null) needAllocOfProfSetup = true;
        if (currentExpensesRateService.findLastEntry(dbUser) == null) needCurExpRateSetup = true;
        model.addAttribute("need_alloc_of_prof", needAllocOfProfSetup);
        model.addAttribute("need_cur_exp_rate", needCurExpRateSetup);
        model.addAttribute("need_cur_exp_renew", needCERenew);
        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());
        model.addAttribute("email", dbUser.getEmail());
        model.addAttribute("phone", dbUser.getPhone());
        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam(required = false) String email, @RequestParam(required = false) String phone) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        CustomUser dbUser = userService.getUserByLogin(login);
        dbUser.setEmail(email);
        dbUser.setPhone(phone);

        userService.updateUser(dbUser);

        return "redirect:/";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String update(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         Model model) {
        if (userService.existsByLogin(login)) {
            model.addAttribute("exists", true);
            return "register";
        }

        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String passHash = encoder.encodePassword(password, null);

        CustomUser dbUser = new CustomUser(login, passHash, UserRole.USER, email, phone);
        userService.addUser(dbUser);

        return "redirect:/";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }

}
