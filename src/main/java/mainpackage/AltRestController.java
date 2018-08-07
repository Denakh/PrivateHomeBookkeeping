package mainpackage;

import mainpackage.entities.users.CustomUser;
import mainpackage.entities.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AltRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody CustomUser user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/get_users")
    public List<CustomUser> get() {
        List<CustomUser> users = userService.getUsers();
        return users;
    }

    /*
    @RequestMapping(value = "/get_users/{role}")
    public List<CustomUser> get(@PathVariable("role") String role) {
        List<CustomUser> users = userService.getUsers();
        return users;
    }
    */
}
