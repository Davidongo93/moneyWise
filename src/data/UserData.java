package data;

import Model.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserData {
    private List<User> users = new ArrayList<>();
    private UserDAOImpl userDAO = new UserDAOImpl(DbConnect.openConnection());

    public UserData() throws SQLException {
        this.users = new ArrayList<>();
    }

    public void addUser(User newUser) {
        userDAO.insertUser(newUser);
    }
}

/*
    public User getUser(String userName, String password) {
        for (User user : users) {
            if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static void getUsers() {
        for (User user : users) {
            System.out.println("UserId:" + user.getId());
            System.out.println("Name:" + user.getName());
            System.out.println("Email:" + user.getEmail());
            System.out.println("---------------------------");
        }
    }

    ;

    public static int userId() {
        return users.size();
    }

    ;*/


