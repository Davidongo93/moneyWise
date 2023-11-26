package business;

import data.EntryData;
import Model.Entry;
import Model.EntryType;

import java.util.Date;
import java.util.Scanner;

public class EntryManager {
    private EntryData entryData;
    private Scanner scanner;

    public EntryManager(EntryData entryData, Scanner scanner) {
        this.entryData = entryData;
        this.scanner = scanner;
    }

    public void addEntry() {
        System.out.print("Enter the date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        // Parse the date string to Date (you might want to handle exceptions here)
        Date date = parseDate(dateString);

        System.out.print("Enter a description: ");
        String description = scanner.nextLine();

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character after the number

        Entry newEntry = new Entry(date, description, amount, EntryType.INCOME);
        entryData.addEntry(newEntry);

        System.out.println("Entry added successfully!");
    }
    public void showEntries(){
        EntryData.getEntries();
    };
    // Add more methods for entry-related logic as needed

    private Date parseDate(String dateString) {
        // You'll need to implement a proper date parsing logic
        // For simplicity, let's assume the date is entered in the format yyyy-MM-dd
        // You might want to use SimpleDateFormat or another approach for production
        return null;
    }
}
