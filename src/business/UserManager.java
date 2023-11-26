package business;

import data.UserData;
import Model.User;

import java.util.Scanner;

public class UserManager {
    private UserData userData;
    private Scanner scanner;
    private boolean userLoggedIn;
    private User loggedInUser;  // Almacena al usuario actualmente logueado

    public UserManager(UserData userData, Scanner scanner) {
        this.userData = userData;
        this.scanner = scanner;
        this.userLoggedIn = false;
        this.loggedInUser = null;
    }

    public  void createUser() {
        System.out.print("Enter a username: ");
        String name = scanner.nextLine();
        System.out.print("Enter a valid email: ");
        String email = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        User newUser = new User(name, email, password);
        userData.addUser(newUser);

        System.out.println("User created successfully!"+ userData.toString());
    }

    public void loginUser() {
        System.out.print("Enter your username: ");
        String name = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        User user = userData.getUser(name,password);

        if (user != null) {
            userLoggedIn = true;
            loggedInUser = user;
            System.out.println("Login successful!");
            System.out.println("welcome!"+ user);
            // You can add more functionality here, like displaying user's entries, etc.
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
    public void createEntry(EntryManager entryManager) {
        entryManager.addEntry();
    }
    public boolean isUserLoggedIn() {
        return userLoggedIn;
    }

    public void logoutUser() {
        userLoggedIn = false;
        loggedInUser = null;
    }
    // Add more methods for user-related logic as needed
};
