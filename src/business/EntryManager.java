package business;

import Model.User;
import data.EntryData;
import Model.Entry;
import Model.EntryType;
import data.UserData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EntryManager {
    private EntryData entryData;
    private Scanner scanner;

    public EntryManager(EntryData entryData, Scanner scanner) {
        this.entryData = entryData;
        this.scanner = scanner;

    }

    public void addEntry(User user) {
        System.out.print("Enter the date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        Date date = parseDate(dateString);

        System.out.print("Enter a description: ");
        String description = scanner.nextLine();

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Entry newEntry = new Entry(date, description, amount, EntryType.INCOME);
        user.setEntries(newEntry);
       // UserData.addEntryToUser();//encuentra el User instanciado correcto)

        System.out.println("Entry added successfully!");
        System.out.println("Dear" + user.getName() + "Here is your entries" + user.getEntries());
    }
    public void showEntries(){
        user.getEntries();
    };


    private Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Error parsing date. Please enter a valid date in the format yyyy-MM-dd.");
            return null;
        }
    }

}
