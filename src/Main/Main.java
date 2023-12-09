package Main;

import data.DbInitializer;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       // data layer
        DbInitializer.main();
        data.UserData userData = new data.UserData();
        data.EntryData entryData = new data.EntryData();

        // business layer
        business.UserManager userManager = new business.UserManager(userData,scanner);
        business.EntryManager entryManager = new business.EntryManager(entryData,scanner);
        // UI layer
        presentation.MenuHandler menuHandler = new presentation.MenuHandler(scanner, userManager, entryManager);

        menuHandler.start();

        scanner.close();
    }
}
