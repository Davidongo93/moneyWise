package presentation;

import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;

    public MenuHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Welcome to Personal Expense Management System MoneyWise");
        System.out.println("Press enter to start...");
        scanner.nextLine(); // Wait for any key press

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
                    // Logic for creating a new user
                    break;
                case 2:
                    // Logic for logging in with an existing user
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }
}
