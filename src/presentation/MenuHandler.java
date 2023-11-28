package presentation;

import business.EntryManager;
import business.UserManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    private UserManager userManager;
    private EntryManager entryManager;

    public MenuHandler(Scanner scanner, UserManager userManager, EntryManager entryManager) {
        this.scanner = scanner;
        this.userManager = userManager;
        this.entryManager = entryManager;
    }

    public void start() {
        System.out.println("Welcome to Personal Expense Management System MoneyWise");
        System.out.println("Press enter to start...");
        scanner.nextLine(); // Wait for enter key press.

        int choice = 0;
        boolean validInput;
        do {
            validInput = false;
            do {

                try {
                    System.out.println("1. Create user");
                    System.out.println("2. Log in with an existing user");
                    System.out.println("3. Exit");
                    System.out.print("Select an option: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    validInput = true;

                } catch (InputMismatchException exception) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine();
                } finally {

                };
            } while (!validInput);  // Repetir hasta que la entrada sea válida

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
        int choice = 0;
        boolean validInput;
        do {
            validInput = false;
            do {
                try {
                    System.out.println("\nUser Menu:");
                    System.out.println("1. View Entries");
                    System.out.println("2. Create Entry");
                    System.out.println("3. Generate Reports");
                    System.out.println("4. Logout");
                    System.out.print("Select an option: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after the number
                    validInput = true;
                }  catch (InputMismatchException exception) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine();
                } finally {

                };
            } while (!validInput);

            switch (choice) {
                case 1:
                    entryManager.showEntries();
                    break;
                case 2:
                    entryManager.addEntry();
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
