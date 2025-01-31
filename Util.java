import java.util.Scanner;

public class Util {
    public static int nextNumber(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.printf("Por favor ingrese un número entre %d y %d%n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido");
            }
        }
    }
}
