package mainpackage.entities.users;

import java.util.List;

public interface UserService {

    CustomUser getUserByLogin(String login);

    CustomUser getUserByRole(UserRole role);

    boolean existsByLogin(String login);

    void addUser(CustomUser customUser);

    void updateUser(CustomUser customUser);

    public List<CustomUser> getUsers();

}
