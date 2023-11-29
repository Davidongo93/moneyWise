package presentation;

import java.io.IOException;

public class Views {

    public static void welcome() {
        System.out.println("Welcome to Personal Expense Management System MoneyWise");
        System.out.println("___  ___                       _    _ _          \n" +
                "|  \\/  |                      | |  | (_)         \n" +
                "| .  . | ___  _ __   ___ _   _| |  | |_ ___  ___ \n" +
                "| |\\/| |/ _ \\| '_ \\ / _ \\ | | | |/\\| | / __|/ _ \\\n" +
                "| |  | | (_) | | | |  __/ |_| \\  /\\  / \\__ \\  __/\n" +
                "\\_|  |_/\\___/|_| |_|\\___|\\__, |\\/  \\/|_|___/\\___|\n" +
                "                          __/ |                  \n" +
                "                         |___/                   ");
        System.out.print("Press enter to start...");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    };
    public static void menuStart(){

    }

}
