package loja.ui;


import java.math.BigDecimal;
import java.time.LocalDate;
import loja.model.cliente.Cliente;
import loja.model.cliente.PessoaFisica;
import loja.model.cliente.PessoaJuridica;
import loja.model.nota.Nota;
import loja.model.produto.Produto;
import loja.model.produto.ProdutoDigital;
import loja.model.produto.ProdutoFisico;
import loja.model.produto.ProdutoPerecivel;



public class ConsoleMenu {

    private static final Produto[] produtos = new Produto[200];
    private static int prod = 0;

    private static final Cliente[] clientes = new Cliente[200];
    private static int clien = 0;

    private static final Nota[] notas = new Nota[200];
    private static int numNotas = 0;

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
                case 1: cadastrarProduto();break;
                case 2: alterarProduto();break;
                case 3: cadastrarCliente();break;
                case 4: alterarCliente();break;
                case 5: criarNota();break;
                case 6: listarNotas();break;
                case 7: listarProdutos();break;
                case 8: listarClientes();break;
                case 0: System.out.println("Saindo do sistema...");break;
                default: System.out.println("Opção inválida.");break;
            }
            

        } while (opcao != 0);
    }


    private void cadastrarProduto() {
        System.out.println(">>> Cadastro de Produtos <<<");


        for(int i =0;i<InputUtils.produtosDigitais.length;i++){
            produtos[prod]=InputUtils.produtosDigitais[i];
            prod++;
        }

        for(int i =0;i<InputUtils.produtosFisicos.length;i++){
            produtos[prod]=InputUtils.produtosFisicos[i];
            prod++;
        }

        for(int i =0;i<InputUtils.produtosPereciveis.length;i++){
            produtos[prod]=InputUtils.produtosPereciveis[i];
            prod++;
        }

        System.out.println("Produtos cadastrados com sucesso!");
    }

    private void alterarProduto() {
        System.out.println(">>> Alterar Produto <<<");
        String codigo = InputUtils.lerTexto("Insira o codigo do produto que queira alterar: ");
        while(!produtoExiste(codigo)){
            System.out.println("Código de Produto não cadastrado, deseja alterar outro produto?");
            int tentativa = InputUtils.lerInteiro("Digite 1 para SIM e 0 para NÃO: ");
            if(tentativa == 1)
                codigo = InputUtils.lerTexto("Insira o codigo do produto: ");
            else{
                System.out.println("Nenhum produto não alterado!");
                return;
            }
        }
        for(int i=0; i<prod;i++){
            if(produtos[i].getCodigo().equalsIgnoreCase(codigo)){
                int atributo;
                if(produtos[i] instanceof ProdutoDigital){
                    atributo = escolheAtributo("1 - Código", "2 - Nome", "3 - Preço Base", "4 - Tamanho do Arquivo em MB", 
                                                "5 - Link para Download do Arquivo");
                    switch (atributo){
                    case 1:
                        String novoCodigo = InputUtils.lerTexto("Insira o novo codigo do produto: ");
                        produtos[i].setCodigo(novoCodigo);
                        break;
                    case 2:
                        String novoNome = InputUtils.lerTexto("Insira o novo nome do produto: ");
                        produtos[i].setNome(novoNome);
                        break;
                    case 3:
                        BigDecimal novoPrecoBase =  InputUtils.lerBigDecimal("Insira o novo preco do produto: ");
                        produtos[i].setPrecoBase(novoPrecoBase);
                        break;
                    case 4:
                        double novoTamanhoDoArquivo = InputUtils.lerDouble("Insira o novo tamanho do arquivo: ");
                        ProdutoDigital pd = (ProdutoDigital) produtos[i];
                        pd.setTamanhoArquivoEmMB(novoTamanhoDoArquivo);
                        break;
                    case 5:
                        String novoLinkDowload = InputUtils.lerTexto("Insira o novo link para dowload do arquivo: ");
                        ProdutoDigital pd2 = (ProdutoDigital) produtos[i];
                        pd2.setLinkDownload(novoLinkDowload);
                        break;
                    }
                }
                if(produtos[i] instanceof ProdutoFisico){
                    atributo = escolheAtributo("1 - Código", "2 - Nome", "3 - Preço Base", "4 - Peso em Gramas", 
                                                "5 - Estoque");
                    switch (atributo){
                    case 1:
                        String novoCodigo = InputUtils.lerTexto("Insira o novo codigo do produto: ");
                        produtos[i].setCodigo(novoCodigo);
                        break;
                    case 2:
                        String novoNome = InputUtils.lerTexto("Insira o novo nome do produto: ");
                        produtos[i].setNome(novoNome);
                        break;
                    case 3:
                        BigDecimal novoPrecoBase =  InputUtils.lerBigDecimal("Insira o novo preco do produto: ");
                        produtos[i].setPrecoBase(novoPrecoBase);
                        break;
                    case 4:
                        double novopesoGramas = InputUtils.lerDouble("Insira o novo peso em gramas do produto: ");
                        ProdutoFisico pd = (ProdutoFisico) produtos[i];
                        pd.setPesoGramas(novopesoGramas);
                        break;
                    case 5:
                        int novoEstoque = InputUtils.lerInteiro("Insira a nova quantidade em estoque do produto: ");
                        ProdutoFisico pd2 = (ProdutoFisico) produtos[i];
                        pd2.setEstoque(novoEstoque);
                        break;
                    }
                }
                if(produtos[i] instanceof ProdutoPerecivel){
                    atributo = escolheAtributo("1 - Código", "2 - Nome", "3 - Preço Base", "4 - Estoque", "5 - Data de Validade");
                    switch (atributo){
                    case 1:
                        String novoCodigo = InputUtils.lerTexto("Insira o novo codigo do produto: ");
                        produtos[i].setCodigo(novoCodigo);
                        break;
                    case 2:
                        String novoNome = InputUtils.lerTexto("Insira o novo nome do produto: ");
                        produtos[i].setNome(novoNome);
                        break;
                    case 3:
                        BigDecimal novoPrecoBase =  InputUtils.lerBigDecimal("Insira o novo preco do produto: ");
                        produtos[i].setPrecoBase(novoPrecoBase);
                        break;
                    case 4:
                        int novoEstoque = InputUtils.lerInteiro("Insira a nova quantidade em estoque do produto: ");
                        ProdutoPerecivel pd1 = (ProdutoPerecivel) produtos[i];
                        pd1.setEstoque(novoEstoque);
                        break;
                    case 5:
                        LocalDate novaDataDeValidade = InputUtils.lerData("Insira a nova data de validade do produto: ");
                        ProdutoPerecivel pd2 = (ProdutoPerecivel) produtos[i];
                        pd2.setDataValidade(novaDataDeValidade);
                        break;
                    }
                }
            }
        }

    }

    private void cadastrarCliente() {
        System.out.println(">>> Cadastro de Cliente <<<");

       for (int i = 0; i < InputUtils.clientesFisicos.length; i++) {
            clientes[clien++] = InputUtils.clientesFisicos[i];
        }

        for (int i = 0; i < InputUtils.clientesJuridicos.length; i++) {
            clientes[clien++] = InputUtils.clientesJuridicos[i];
        }

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void alterarCliente() {
        System.out.println(">>> Alterar Cliente <<<");
        String identificador = InputUtils.lerTexto("Insira o identificador do cliente que queira alterar: ");
        while(!clienteExiste(identificador)){
            System.out.println("Cliente não cadastrado, deseja alterar outro cliente?");
            int tentativa = InputUtils.lerInteiro("Digite 1 para SIM e 0 para NÃO: ");
            if(tentativa == 1)
                identificador = InputUtils.lerTexto("Insira o identificador do cliente: ");
            else{
                System.out.println("Nenhum cliente alterado!");
                return;
            }
        }
        for(int i=0; i<clien;i++){
            if(clientes[i].getIdentificador().equalsIgnoreCase(identificador)){
                int atributo;
                if(clientes[i] instanceof PessoaFisica){
                    atributo = escolheAtributo("1 - Identificador", "2 - Nome", "3 - Endereço", "4 - Telefone", 
                                                "5 - CPF");
                    switch (atributo){
                    case 1:
                        String novoIdentificador = InputUtils.lerTexto("Insira o novo identificador do cliente: ");
                        clientes[i].setIdentificador(novoIdentificador);
                        break;
                    case 2:
                        String novoNome = InputUtils.lerTexto("Insira o novo nome do cliente: ");
                        clientes[i].setNome(novoNome);
                        break;
                    case 3:
                        String novoEndereco = InputUtils.lerTexto("Insira o novo endereço do cliente: ");
                        clientes[i].setEndereco(novoEndereco);
                        break;
                    case 4:
                        String novoTelefone = InputUtils.lerTexto("Insira o novo telefone do cliente(exemplo->(DDD)NNNNN-NNNN ): ");
                        clientes[i].setTelefone(novoTelefone);
                        break;
                    case 5:
                        String novoCpf = InputUtils.lerTexto("Insira o novo CPF do cliente: ");
                        PessoaFisica ps1 = (PessoaFisica) clientes[i];
                        ps1.setCpf(novoCpf);
                        break;
                    }
                }
                if(clientes[i] instanceof PessoaJuridica){
                    atributo = escolheAtributo("1 - Identificador", "2 - Nome", "3 - Endereço", "4 - Telefone", 
                                                "5 - CNPJ");
                    switch (atributo){
                    case 1:
                        String novoIdentificador = InputUtils.lerTexto("Insira o identificador do cliente: ");
                        clientes[i].setIdentificador(novoIdentificador);
                        break;
                    case 2:
                        String novoNome = InputUtils.lerTexto("Insira o novo nome do cliente: ");
                        clientes[i].setNome(novoNome);
                        break;
                    case 3:
                        String novoEndereco = InputUtils.lerTexto("Insira o novo endereço do cliente: ");
                        clientes[i].setEndereco(novoEndereco);
                        break;
                    case 4:
                        String novoTelefone = InputUtils.lerTexto("Insira o novo telefone do cliente(exemplo->(DDD)NNNNN-NNNN ): ");
                        clientes[i].setTelefone(novoTelefone);
                        break;
                    case 5:
                        String novoCnpj = InputUtils.lerTexto("Insira o novo CNPJ do cliente: ");;
                        PessoaJuridica ps1 = (PessoaJuridica) clientes[i];
                        ps1.setCnpj(novoCnpj);
                        break;
                    }
                }
            }
        }
    }

    private void criarNota() {
        //verificar se há clientes
        if (clien == 0) {
            System.out.println("Não há clientes cadastrados.");
            return;
        }

        //verificar se há produtos
        if (prod == 0) {
            System.out.println("Não há produtos cadastrados.");
            return;
        }

        Cliente clienteSelecionado;
        Nota novo;
        //escolher clientes cadastrados
        System.out.println("<<< Clientes Cadastrados >>>");
        for(int i = 0; i < clien; i++){
            System.out.println(i+1 + "-  " + clientes[i].getNome());
        }
            int ncliente = InputUtils.lerInteiro("Selecione o cliente da nota: ");

        if(ncliente < 1 || ncliente > clien){
            System.out.println("Cliente inválido.");
            return;
        }

        clienteSelecionado = clientes[ncliente - 1];
        

        novo = new Nota(clienteSelecionado);

        System.out.println("<<< Produtos Cadastrados >>>");
        for(int i = 0; i < prod; i++){
            System.out.println(i+1 + "- " + produtos[i].getNome());
        }

        int novoProdutoNota;
        do{
            int produtoNaNota = InputUtils.lerInteiro("Selecione o produto da Compra: ");

            if(produtoNaNota < 1 || produtoNaNota > prod){
                System.out.println("Produto inválido.");
                return;
            }
            int quantidadeProdutoNaNota = InputUtils.lerInteiro("Selecione a quantidade do produto nessa Compra: ");
            novo.cadastrarItemNota(produtos[produtoNaNota-1], quantidadeProdutoNaNota);
            if(produtos[produtoNaNota-1]instanceof ProdutoFisico){
                ProdutoFisico pd2 = (ProdutoFisico) produtos[produtoNaNota-1];
                pd2.setEstoque(pd2.getEstoque()-quantidadeProdutoNaNota);
            }else if(produtos[produtoNaNota-1]instanceof ProdutoPerecivel){
                ProdutoPerecivel pd2 = (ProdutoPerecivel) produtos[produtoNaNota-1];
                pd2.setEstoque(pd2.getEstoque()-quantidadeProdutoNaNota);
            }
            System.out.println("Deseja cadastrar outro produto?");
            novoProdutoNota = InputUtils.lerInteiro("Digite 1 para SIM e 0 para NÃO: ");
        }while(novoProdutoNota == 1);
        System.out.println(">>> Nota de Compra <<<");
        novo.imprimirNota();
        notas[numNotas] = novo;
        numNotas++;
    }

    private void listarNotas() {
        System.out.println(">>> Notas Emitidas <<<");
        for (int i = 0; i < numNotas; i++) {
        notas[i].imprimirNota();
        System.out.println("----------------------------------------------------");
        }
    }

    private void listarProdutos() {
        System.out.println(">>> Produtos Cadastrados <<<");
        for(int i=0; i<prod;i++){
            System.out.println(i+1 + "-    " + produtos[i].getNome());
            System.out.println("- Código: " + produtos[i].getCodigo());
            System.out.println("- Preço Base: " + produtos[i].getPrecoBase());
            if(produtos[i] instanceof ProdutoDigital){
            ProdutoDigital pd = (ProdutoDigital) produtos[i];
            System.out.println("- Tipo: Produto Digital");
            System.out.println("- Tamanho do Arquivo: " + pd.getTamanhoArquivoEmMB());
            System.out.println("- Link para Download do Arquivo: " + pd.getLinkDownload());
            }

            if(produtos[i] instanceof ProdutoFisico){
            ProdutoFisico pd1 = (ProdutoFisico) produtos[i];
            System.out.println("- Tipo: Produto Físico");
            System.out.println("- Peso em Gramas do Produto: " + pd1.getPesoGramas());
            System.out.println("- Estoque: " + pd1.getEstoque());
            }

            if(produtos[i] instanceof ProdutoPerecivel){
            ProdutoPerecivel pd2 = (ProdutoPerecivel) produtos[i];
            System.out.println("- Tipo: Produto Perecível");
            System.out.println("- Estoque: " + pd2.getEstoque());
            System.out.println("- Data de Validade do Lote: " + pd2.getDataValidade());
            }
        }
    }

    private void listarClientes() {
        System.out.println(">>> Clientes Cadastrados <<<");
        for(int i=0; i<clien;i++){
            if(clientes[i] instanceof PessoaFisica){
            PessoaFisica ps = (PessoaFisica) clientes[i];
            System.out.println(i+1);
            ps.exibirInformacoes();
            }

            if(clientes[i] instanceof PessoaJuridica){
            PessoaJuridica ps1 = (PessoaJuridica) clientes[i];
            System.out.println(i+1);
            ps1.exibirInformacoes();
            }
        }
    }
    
    public int escolheAtributo(String string1, String string2, String string3, String string4, String string5){
        int atributo;
        do {
                    System.out.println("Insira o qual atributo que deseja alterar: ");
                    System.out.println(string1);
                    System.out.println(string2);
                    System.out.println(string3);
                    System.out.println(string4);
                    System.out.println(string5);
                    atributo = InputUtils.lerInteiro("opção: ");
                }  while(atributo < 1 | atributo > 6);
        return atributo;
    }

    private boolean produtoExiste(String codigo) {
    for (int i = 0; i < prod; i++) {
        if (produtos[i].getCodigo().equalsIgnoreCase(codigo)) 
            return true;
        }
    return false;
}

    private boolean clienteExiste(String identificador) {
    for (int i = 0; i < clien; i++) {
        if (clientes[i].getIdentificador().equalsIgnoreCase(identificador))
            return true;
        }
    return false;
}

}