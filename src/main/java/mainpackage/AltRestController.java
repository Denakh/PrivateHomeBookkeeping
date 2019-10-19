package mainpackage;

import mainpackage.entities.users.CustomUser;
import mainpackage.entities.users.UserRole;
import mainpackage.entities.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AltRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody CustomUser user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/get_users")
    public List<CustomUser> getUsersList() {
        return userService.getUsers();
    }


    @RequestMapping(value = "/get_users/{role}")
    public List<CustomUser> get(@PathVariable("role") String role) {
        UserRole userRole;
        try {
            userRole = UserRole.valueOf(role);
        } catch (EnumConstantNotPresentException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return userService.getUserByRole(userRole);
    }

}
