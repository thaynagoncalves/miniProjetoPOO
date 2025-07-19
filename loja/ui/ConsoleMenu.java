package loja.ui;

import loja.model.produto.Produto;
import loja.model.produto.ProdutoDigital;
import loja.model.produto.ProdutoFisico;
import loja.model.produto.ProdutoPerecivel;

import java.math.BigDecimal;
import java.time.LocalDate;



public class ConsoleMenu {

    private static final Produto[] produtos = new Produto[200];
    private static int prod = 0;

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
                case 1 ->{
                            System.out.println("===Cadastro Produto===");




                    String codigo = InputUtils.lerTexto("Insira o codigo do produto: ");//verificar se é unico?

                    String nome = InputUtils.lerTexto("Insira o nome do produto: ");

                    BigDecimal precoBase =  InputUtils.lerBigDecimal("Insira o preco do produto: ");


                    int op;
                    do {
                        System.out.println("Insira o tipo do produto: ");
                        System.out.println(("1 - Produto digital"));
                        System.out.println(("2 - Produto físico"));
                        System.out.println("3 - Produto perecível");
                         op = InputUtils.lerInteiro("opção: ");
                    }  while(op < 1 || op > 3);


                        Produto novo = null;
                        switch (op){
                            case 1:
                                double tamanhoDoArquivo = InputUtils.lerDouble("Insira o tamanho do arquivo: ");
                                String formatoDoArquivo = InputUtils.lerTexto("Insira o formato do arquivo: ");
                                String linkDowload = InputUtils.lerTexto("Insira o link para dowload do arquivo: ");
                                novo = new ProdutoDigital(codigo,nome,precoBase,tamanhoDoArquivo,formatoDoArquivo,linkDowload);
                                break;
                            case 2:
                                double pesoGramas = InputUtils.lerDouble("Insira o peso em gramas do produto: ");
                                int estoque = InputUtils.lerInteiro("Insira a quantidade em estoque do produto: ");
                                novo = new ProdutoFisico(codigo,nome,precoBase,pesoGramas,estoque);
                                break;
                            case 3:
                                LocalDate dataDeValidade = InputUtils.lerData("Insira a data de validade do produto: ");
                                double precoGramas2 = InputUtils.lerDouble("Insira o peso em gramas do produto: ");
                                int estoque2 = InputUtils.lerInteiro("Insira a quantidade em estoque do produto: ");
                                novo = new ProdutoPerecivel(codigo,nome,precoBase,precoGramas2,dataDeValidade,estoque2);
                                break;


                        }

                        produtos[prod] = novo;
                        prod++;

                    System.out.println("Produto cadastrado com sucesso!");
                    InputUtils.pausar();


                }
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
    private void listarClientes() {
        System.out.println(">>> Clientes Cadastrados <<<");
    }
}
