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
        Date date = parseDate(dateString);

        System.out.print("Enter a description: ");
        String description = scanner.nextLine();

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Entry newEntry = new Entry(date, description, amount, EntryType.INCOME);
        entryData.addEntry(newEntry);

        System.out.println("Entry added successfully!");
    }
    public void showEntries(){
        entryData.showEntries();
    };


    private Date parseDate(String dateString) {

        return null;
    }
}
