package loja.ui;

public class ConsoleMenu {
    
    public void iniciar() {
        int opcao;
        do {
            System.out.println("===== SISTEMA DA LOJA =====");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Cadastrar Cliente");
            System.out.println("4. Alterar Cliente");
            System.out.println("5. Criar Nota de Compra");
            System.out.println("6. Listar Notas Emitidas");
            System.out.println("7. Listar Produtos");
            System.out.println("8. Listar Clientes");
            System.out.println("0. Sair");

            opcao = InputUtils.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> alterarProduto();
                case 3 -> cadastrarCliente();
                case 4 -> alterarCliente();
                case 5 -> criarNota();
                case 6 -> listarNotas();
                case 7 -> listarProdutos();
                case 8 -> listarClientes();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida.");
            }

            InputUtils.pausar();

        } while (opcao != 0);
    }

    // Métodos abaixo são placeholders que você irá implementar

    private void cadastrarProduto() {
        System.out.println(">>> Cadastro de Produto <<<");
        // use InputUtils.lerTexto, lerBigDecimal, etc.
    }

    private void alterarProduto() {
        System.out.println(">>> Alterar Produto <<<");
    }

    private void cadastrarCliente() {
        System.out.println(">>> Cadastro de Cliente <<<");
    }

    private void alterarCliente() {
        System.out.println(">>> Alterar Cliente <<<");
    }

    private void criarNota() {
        System.out.println(">>> Criar Nota de Compra <<<");
    }

    private void listarNotas() {
        System.out.println(">>> Notas Emitidas <<<");
    }

    private void listarProdutos() {
        System.out.println(">>> Produtos Cadastrados <<<");
    }

    private void listarClientes() {
        System.out.println(">>> Clientes Cadastrados <<<");
    }
}