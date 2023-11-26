package presentation;

import business.UserManager;

import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    private UserManager userManager;

    public MenuHandler(Scanner scanner, UserManager userManager) {
        this.scanner = scanner;
        this.userManager = userManager;
    }

    public void start() {
        System.out.println("Welcome to Personal Expense Management System MoneyWise");
        System.out.println("Press enter to start...");
        scanner.nextLine(); // Wait for enter key press.

        int choice;
        do {
            System.out.println("1. Create user");
            System.out.println("2. Log in with an existing user");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the number

            switch (choice) {
                case 1:
                    userManager.createUser();
                    break;
                case 2:
                    userManager.loginUser();
                    if (userManager.isUserLoggedIn()) {
                        showUserMenu();
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }

    private void showUserMenu() {
        int choice;
        do {
            System.out.println("\nUser Menu:");
            System.out.println("1. View Entries");
            System.out.println("2. Create Entry");
            System.out.println("3. Generate Reports");
            System.out.println("4. Logout");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the number

            switch (choice) {
                case 1:
                    //NIY userManager.showUserEntries();
                    break;
                case 2:
                   //NIY userManager.createEntry();
                    break;
                case 3:
                    // Logic for generating reports
                    System.out.println("Generating Reports...");
                    break;
                case 4:
                    userManager.logoutUser();
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }
}
