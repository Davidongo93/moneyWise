package Main;

import presentation.MenuHandler;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Inicializar el manejador de menú
        presentation.MenuHandler menuHandler = new presentation.MenuHandler(scanner);

        // Puedes pasar las instancias necesarias a las clases correspondientes

        // Iniciar la aplicación
        menuHandler.start();

        scanner.close();
    }
}
