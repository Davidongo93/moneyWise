package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       // Inicializar instancias de las clases de la capa de datos
        data.UserData userData = new data.UserData();
        data.EntryData entryData = new data.EntryData();

        // Inicializar instancias de las clases de la capa de negocio
        business.UserManager userManager = new business.UserManager(userData,scanner);
        business.EntryManager entryManager = new business.EntryManager(entryData,scanner);
        // Inicializar el manejador de menú
        // ...
        presentation.MenuHandler menuHandler = new presentation.MenuHandler(scanner, userManager, entryManager);
// ...


        // Puedes pasar las instancias necesarias a las clases correspondientes

        // Iniciar la aplicación
        menuHandler.start();

        scanner.close();
    }
}
