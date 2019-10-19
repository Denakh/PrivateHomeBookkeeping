package mainpackage.entities.users;

import java.util.List;

public interface UserService {

    CustomUser getUserByLogin(String login);

    boolean existsByLogin(String login);

    void addUser(CustomUser customUser);

    void updateUser(CustomUser customUser);

    List<CustomUser> getUserByRole(UserRole role);

    List<CustomUser> getUsers();

}
