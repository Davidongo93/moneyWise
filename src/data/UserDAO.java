package data;

import java.util.List;

import Model.Entry;
import Model.User;

public interface UserDAO {
    void insertUser(User user);
    User getUserByUsername(String username, String password);
    /*

    void updateUser(User user);
    void deleteUserByUsername(String username);
    List<Entry> getUserEntries(String username);
    */
}
