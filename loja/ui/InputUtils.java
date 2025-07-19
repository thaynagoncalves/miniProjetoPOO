package loja.ui;

import java.util.Scanner;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter FORMAT_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    public static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número inteiro.");
            }
        }
    }

    public static BigDecimal lerBigDecimal(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return new BigDecimal(scanner.nextLine().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número válido, como 10.50.");
            }
        }
    }

    public static LocalDate lerData(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem + " (dd/MM/yyyy): ");
                String entrada = scanner.nextLine();
                return LocalDate.parse(entrada, FORMAT_BR);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Use o formato dd/MM/yyyy.");
            }
        }
    }

    public static void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}