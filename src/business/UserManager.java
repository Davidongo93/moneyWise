package business;

import data.UserDAO;
import data.UserDAOImpl;
import data.UserData;
import Model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class UserManager {
    private UserData userData;
    private Scanner scanner;
    private boolean userLoggedIn;
    private User loggedInUser;
    public UserManager(UserData userData, Scanner scanner) {
        this.userData = userData;
        this.scanner = scanner;
        this.userLoggedIn = false;
        this.loggedInUser = null;
    }


    public  User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void newUser (User newUser){
        UserDAO userDAO = new UserDAOImpl();
        try {
            userDAO.insertUser(newUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void loginUser() {
        System.out.print("Enter your username: ");
        String name = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

       User user = userData.getUser(name, password);

        if (user != null) {
            userLoggedIn = true;
            loggedInUser = user;
            System.out.println("Login successful!");
            System.out.println("welcome!"+ user.getName());
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
    public boolean isUserLoggedIn() {
        return userLoggedIn;
    }

    public void logoutUser() {
        userLoggedIn = false;
        loggedInUser = null;
    }

};
