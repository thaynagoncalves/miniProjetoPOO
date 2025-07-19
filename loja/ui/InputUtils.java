package loja.ui;

import java.util.Scanner;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    public static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        String entrada = scanner.nextLine();
        // Assume que o usuário digitou corretamente
        return Integer.parseInt(entrada);
    }

    public static BigDecimal lerBigDecimal(String mensagem) {
        System.out.print(mensagem);
        String entrada = scanner.nextLine().replace(",", ".");
        return new BigDecimal(entrada);
    }

    public static LocalDate lerData(String mensagem) {
        System.out.print(mensagem + " (yyyy-MM-dd): ");
        String entrada = scanner.nextLine();
        // Espera entrada no formato ISO: "2025-07-19"
        return LocalDate.parse(entrada); 
    }

    public static LocalDateTime lerDataHora(String mensagem) {
        System.out.print(mensagem + " (yyyy-MM-ddTHH:mm): ");
        String entrada = scanner.nextLine();
        // Espera entrada no formato ISO: "2025-07-19T14:00"
        return LocalDateTime.parse(entrada);
    }

    public static void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}