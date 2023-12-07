package data;

import java.sql.SQLException;
import java.util.List;

import Model.Entry;
import Model.User;

public interface UserDAO {
    void insertUser(User user)  throws SQLException;
    User getUserByUsername(String username, String password)throws SQLException;
    /*

    void updateUser(User user);
    void deleteUserByUsername(String username);
    List<Entry> getUserEntries(String username);
    */
}
