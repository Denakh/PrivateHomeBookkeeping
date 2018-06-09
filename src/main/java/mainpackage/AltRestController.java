package mainpackage;

import mainpackage.entities.income.IncomeService;
import mainpackage.entities.users.CustomUser;
import mainpackage.entities.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
public class AltRestController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/get_users")
    public List<CustomUser> get() {
        List<CustomUser> users = userService.getUsers();
        return users;
    }

}
