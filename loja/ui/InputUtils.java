package loja.ui;

import java.util.Scanner;

import loja.model.cliente.PessoaFisica;
import loja.model.cliente.PessoaJuridica;
import loja.model.produto.ProdutoDigital;
import loja.model.produto.ProdutoFisico;
import loja.model.produto.ProdutoPerecivel;

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

    public static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número válido, como 42.0.");
            }
        }
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


    // Lista com 15 objetos de ProdutoDigital
    public static ProdutoDigital[] produtosDigitais = new ProdutoDigital[] {
    new ProdutoDigital("778245","E-book: Java Básico", new BigDecimal("19.90"), 3.5,"https://downloads.exemplo.com/java-basico"),
    new ProdutoDigital("631497","Curso Python Intermediário", new BigDecimal("79.90"), 1500.0,"https://downloads.exemplo.com/curso-python"),
    new ProdutoDigital("287391","Apostila de Redes", new BigDecimal("12.50"), 2.1,"https://downloads.exemplo.com/curso-python"),
    new ProdutoDigital("704326","Software Antivírus", new BigDecimal("99.99"), 500.0,"https://downloads.exemplo.com/curso-python"),
    new ProdutoDigital("918057","Pacote Office Alternativo", new BigDecimal("39.90"), 750.0,"https://downloads.exemplo.com/pacote-office"),
    new ProdutoDigital("145092","Revista Digital: Ciência Hoje", new BigDecimal("9.90"), 1.2,"https://downloads.exemplo.com/revista-ciencia"),
    new ProdutoDigital("309276","MP3: Álbum Rock Clássico", new BigDecimal("15.00"), 80.0,"https://downloads.exemplo.com/album-rockClassico"),
    new ProdutoDigital("826431","Filme HD: Matrix", new BigDecimal("25.90"), 1500.0,"https://downloads.exemplo.com/matrix"),
    new ProdutoDigital("487519","Videoaula Álgebra Linear", new BigDecimal("49.90"), 320.0,"https://downloads.exemplo.com/algebra-linear"),
    new ProdutoDigital("163892","Aplicativo de Lista de Tarefas", new BigDecimal("5.99"), 12.0,"https://downloads.exemplo.com/app-lista-de-tarefas"),
    new ProdutoDigital("735180","E-book: Filosofia Moderna", new BigDecimal("17.90"), 4.2,"https://downloads.exemplo.com/filosofia-moderna"),
    new ProdutoDigital("592803","Simulador Financeiro", new BigDecimal("29.90"), 30.0,"https://downloads.exemplo.com/simulador-financeiro"),
    new ProdutoDigital("387109","Curso Excel Avançado", new BigDecimal("59.90"), 1100.0,"https://downloads.exemplo.com/curso-excel"),
    new ProdutoDigital("908123","Pack de ícones SVG", new BigDecimal("4.90"), 0.6,"https://downloads.exemplo.com/pack-svg"),
    new ProdutoDigital("147630","Jogo Indie: FlappyCube", new BigDecimal("14.90"), 250.0,"https://downloads.exemplo.com/jogo-flappyCube"),
    };

     // Lista com 15 objetos de ProdutoFisico
    public static ProdutoFisico[] produtosFisicos = new ProdutoFisico[] {
    new ProdutoFisico("835720","Geladeira", new BigDecimal("1650.39"), 8.52,809),
    new ProdutoFisico("104385","Fogão", new BigDecimal("2204.58"), 8.62,93),
    new ProdutoFisico("927143","Notebook", new BigDecimal("1824.14"), 13.89,70),
    new ProdutoFisico("592861","TV 4K", new BigDecimal("1104.14"), 7.89,56),
    new ProdutoFisico("340752","Ar Condicionado", new BigDecimal("2599.99"), 25.50,78),
    new ProdutoFisico("918437","Micro-ondas", new BigDecimal("780.50"), 9.20,98),
    new ProdutoFisico("374906","Cafeteira", new BigDecimal("299.99"), 2.30,74),
    new ProdutoFisico("152904","Impressora", new BigDecimal("650.70"), 4.10,65),
    new ProdutoFisico("209175","Monitor", new BigDecimal("920.90"), 6.75,120),
    new ProdutoFisico("863210","Teclado Mecânico", new BigDecimal("420.00"), 1.20,154),
    new ProdutoFisico("401732","Aspirador de Pó", new BigDecimal("510.00"), 3.80,365),
    new ProdutoFisico("728640","Cadeira Gamer", new BigDecimal("1500.00"), 18.70,123),
    new ProdutoFisico("692318","Roteador", new BigDecimal("280.00"), 0.95,65),
    new ProdutoFisico("132754","Relógio Digital", new BigDecimal("129.90"), 0.30,235),
    new ProdutoFisico("950164","Ventilador", new BigDecimal("210.00"), 4.00,489)
    };

    // Lista com 15 objetos de ProdutoPerecivel
    public static ProdutoPerecivel[] produtosPereciveis = new ProdutoPerecivel[] {
    new ProdutoPerecivel("801342","Leite Integral", new BigDecimal("5.49"), LocalDate.of(2025, 8, 15),809),
    new ProdutoPerecivel("246931","Pão de Forma", new BigDecimal("6.99"), LocalDate.of(2025, 8, 10),93),
    new ProdutoPerecivel("759218","Queijo Mussarela", new BigDecimal("18.90"), LocalDate.of(2025, 8, 20),70),
    new ProdutoPerecivel("365901","Presunto Cozido", new BigDecimal("15.50"), LocalDate.of(2025, 8, 14),56),
    new ProdutoPerecivel("671298","Iogurte Natural", new BigDecimal("3.25"), LocalDate.of(2025, 8, 9),78),
    new ProdutoPerecivel("123570","Requeijão Cremoso", new BigDecimal("7.10"), LocalDate.of(2025, 9, 5),98),
    new ProdutoPerecivel("907542","Leite Condensado", new BigDecimal("4.80"), LocalDate.of(2026, 1, 10),74),
    new ProdutoPerecivel("842169","Manteiga com Sal", new BigDecimal("10.90"), LocalDate.of(2025, 10, 3),65),
    new ProdutoPerecivel("395807","Creme de Leite", new BigDecimal("4.30"), LocalDate.of(2025, 9, 2), 120),
    new ProdutoPerecivel("289073","Salsicha Hot Dog", new BigDecimal("12.99"), LocalDate.of(2025, 8, 7),154),
    new ProdutoPerecivel("781623","Frango Congelado", new BigDecimal("24.90"), LocalDate.of(2025, 12, 31),365),
    new ProdutoPerecivel("609472","Carne Moída", new BigDecimal("32.50"), LocalDate.of(2025, 8, 8), 123),
    new ProdutoPerecivel("304826","Linguiça Toscana", new BigDecimal("19.90"), LocalDate.of(2025, 8, 12),65),
    new ProdutoPerecivel("983124","Hambúrguer Bovina", new BigDecimal("16.90"), LocalDate.of(2025, 8, 25),235),
    new ProdutoPerecivel("518732","Peito de Frango", new BigDecimal("28.00"), LocalDate.of(2025, 8, 18), 489)
    };

    public static PessoaFisica[] clientesFisicos = new PessoaFisica[] {
    new PessoaFisica("PF001", "Ana Souza", "Rua das Flores, 123", "11999990001", "123.456.789-00"),
    new PessoaFisica("PF002", "Carlos Lima", "Av. Paulista, 1000", "11988887777", "321.654.987-11"),
    new PessoaFisica("PF003", "Beatriz Mendes", "Rua Verde, 45", "11977776666", "456.789.123-99"),
    new PessoaFisica("PF004", "Eduardo Silva", "Rua Azul, 87", "11966665555", "987.654.321-88"),
    new PessoaFisica("PF005", "Fernanda Dias", "Rua da Paz, 200", "11955554444", "789.123.456-77"),
    new PessoaFisica("PF006", "João Pedro", "Av. Central, 505", "11944443333", "111.222.333-44"),
    new PessoaFisica("PF007", "Larissa Matos", "Rua Campo Belo, 12", "11933332222", "555.666.777-88"),
    new PessoaFisica("PF008", "Rafael Torres", "Rua da Praia, 89", "11922221111", "999.000.111-22"),
    new PessoaFisica("PF009", "Isabela Rocha", "Rua do Sol, 21", "11911112222", "888.777.666-55"),
    new PessoaFisica("PF010", "Bruno Oliveira", "Av. Brasil, 432", "11900001111", "222.333.444-55"),
    new PessoaFisica("PF011", "Juliana Alves", "Rua do Norte, 9", "11888889999", "111.999.888-00"),
    new PessoaFisica("PF012", "Diego Ferreira", "Rua Azul Marinho, 67", "11877778888", "444.555.666-77"),
    new PessoaFisica("PF013", "Amanda Costa", "Rua Jardim, 44", "11866667777", "333.444.555-66"),
    new PessoaFisica("PF014", "Thiago Martins", "Rua Céu Azul, 101", "11855556666", "666.777.888-99"),
    new PessoaFisica("PF015", "Patrícia Lima", "Rua dos Lírios, 88", "11844445555", "777.888.999-00")
    };
    
    public static PessoaJuridica[] clientesJuridicos = new PessoaJuridica[] {
    new PessoaJuridica("PJ001", "Tech Solutions LTDA", "Av. Industrial, 1000", "11333334444", "12.345.678/0001-90"),
    new PessoaJuridica("PJ002", "Comercial Silva ME", "Rua do Comércio, 321", "11322223333", "98.765.432/0001-12"),
    new PessoaJuridica("PJ003", "Construtora ABC", "Av. Obra Nova, 55", "11311112222", "11.111.111/0001-11"),
    new PessoaJuridica("PJ004", "Papelaria Ideal", "Rua Caneta Azul, 789", "11299998888", "22.222.222/0001-22"),
    new PessoaJuridica("PJ005", "Alimentos Bom Sabor", "Av. Gourmet, 1234", "11288887777", "33.333.333/0001-33"),
    new PessoaJuridica("PJ006", "Consultoria Premium", "Rua dos Negócios, 90", "11277776666", "44.444.444/0001-44"),
    new PessoaJuridica("PJ007", "Auto Peças Rápido", "Av. Carro, 42", "11266665555", "55.555.555/0001-55"),
    new PessoaJuridica("PJ008", "Serviços TI BR", "Rua Tecnológica, 15", "11255554444", "66.666.666/0001-66"),
    new PessoaJuridica("PJ009", "Loja de Roupas Fina", "Av. Moda, 87", "11244443333", "77.777.777/0001-77"),
    new PessoaJuridica("PJ010", "Indústria Plásticos BR", "Rua Fábrica, 200", "11233332222", "88.888.888/0001-88"),
    new PessoaJuridica("PJ011", "Farmácia Vida", "Av. Saúde, 301", "11222221111", "99.999.999/0001-99"),
    new PessoaJuridica("PJ012", "Academia Fit Pro", "Rua do Corpo, 707", "11211110000", "10.101.010/0001-10"),
    new PessoaJuridica("PJ013", "Editora Saber", "Av. Conhecimento, 81", "11199998877", "12.121.212/0001-21"),
    new PessoaJuridica("PJ014", "Transportadora Rápida", "Rua Caminhão, 202", "11188887766", "13.131.313/0001-31"),
    new PessoaJuridica("PJ015", "Eventos Alegria", "Av. Festa, 999", "11177776655", "14.141.414/0001-41")
    };

}