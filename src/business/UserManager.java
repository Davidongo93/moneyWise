package business;

import data.UserData;
import Model.User;

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

    public void createUser() {
        System.out.print("Enter a username: ");
        String name = scanner.nextLine();
        System.out.print("Enter a valid email: ");
        String email = scanner.nextLine();

        boolean passwordValid = false;
        do {
            try {
                System.out.print("Enter a password: ");
                String password = scanner.nextLine();
                System.out.print("Confirm password: ");
                String confirmedPassword = scanner.nextLine();

                PasswordValidator.validatePassword(password, confirmedPassword);

                User newUser = new User(name, email, password);
                userData.addUser(newUser);

                System.out.println("User created successfully!");
                passwordValid = true;
            } catch (PasswordValidationException e) {
                System.out.println("Error creating user: " + e.getMessage());
                System.out.println("Please try again.");
            }
        } while (!passwordValid);
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
};
