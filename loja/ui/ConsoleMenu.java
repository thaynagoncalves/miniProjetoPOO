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
            if(opcao != 0)
            InputUtils.pausar();
            

        } while (opcao != 0);
    }

    // Métodos abaixo são placeholders que você irá implementar

    private void cadastrarProduto() {
        System.out.println(">>> Cadastro de Produto <<<");
        String codigo;
        do{
            codigo = InputUtils.lerTexto("Insira o codigo do produto:(6 dígitos numéricos ) ");
            
            if(!codigoValido(codigo))
            System.out.println("Digite um código válido!");
            
        }while(!codigoValido(codigo));
        while(produtoExiste(codigo)){
            System.out.println("Código de Produto já inserido, deseja cadastrar outro produto?");
            int tentativa = InputUtils.lerInteiro("Digite 1 para SIM e 0 para NÃO: ");
            if(tentativa == 1)
                codigo = InputUtils.lerTexto("Insira o codigo do produto: ");
            else{
                System.out.println("Produto não cadastrado!");
                return;
            }
        }
        String nome;

        BigDecimal precoBase;
        do{
            precoBase =  InputUtils.lerBigDecimal("Insira o preco do produto: R$");

            if(!valorValido(precoBase))
            System.out.println("Insira um valor válido! (maior que zero)");

        }while(!valorValido(precoBase));


        int op;
        do {
            System.out.println("Insira o tipo do produto: ");
            System.out.println("1 - Produto digital");
            System.out.println("2 - Produto físico");
            System.out.println("3 - Produto perecível");
            op = InputUtils.lerInteiro("opção: ");
        }  while(op < 1 || op > 3);


        if(op == 2 || op == 3){
         nome = InputUtils.lerTexto("Insira o nome do produto:(sem valores númericos) ");
         do{
            if(!nomeValido(nome)){
            System.out.println("Insira um nome valido!!");
            nome = InputUtils.lerTexto("Insira o nome do produto:(sem valores númericos) ");
            }
            else
            break;
         }while(!nomeValido(nome));
        }
         else{
            nome = InputUtils.lerTexto("Insira o nome do produto: ");
         }
        Produto novo = null;

        switch (op){
        case 1:
            double tamanhoDoArquivo;
            do{
            tamanhoDoArquivo = InputUtils.lerDouble("Insira o tamanho do arquivo: ");
            

            if(!valorValidoD(tamanhoDoArquivo)){
                System.out.println("Insira um valor válido! (maior que zero)");
            }
            }while(!valorValidoD(tamanhoDoArquivo));
            String formatoDoArquivo = InputUtils.lerTexto("Insira o formato do arquivo: ");
            String linkDowload = InputUtils.lerTexto("Insira o link para dowload do arquivo: ");
            novo = new ProdutoDigital(codigo,nome,precoBase,tamanhoDoArquivo,formatoDoArquivo,linkDowload);
            break;
        case 2:
            double pesoGramas;
            do{
                pesoGramas = InputUtils.lerDouble("Insira o peso em gramas do produto: ");
                if(!valorValidoD(pesoGramas))
                System.out.println("Insira um valor válido!(maior que zero)");
            }while(!valorValidoD(pesoGramas));

            int estoque;

            do{
                estoque = InputUtils.lerInteiro("Insira a quantidade em estoque do produto: ");
                if(!valorValidoI(estoque))
                 System.out.println("Insira um valor válido!(maior que zero)");

            }while(!valorValidoI(estoque));

            novo = new ProdutoFisico(codigo,nome,precoBase,pesoGramas,estoque);
            break;
        case 3:
            LocalDate dataDeValidade;

            do { 
               dataDeValidade = InputUtils.lerData("Insira a data de validade do produto: ");

               if(!verificarData(dataDeValidade))
               System.out.println("Insira uma data valida!(entre um ano de validade)");
            } while (!verificarData(dataDeValidade));


            double pesoGramas2;
             do{
             pesoGramas2 = InputUtils.lerDouble("Insira o peso em gramas do produto: ");
                if(!valorValidoD(pesoGramas2))
                System.out.println("Insira um valor válido!(maior que zero)");
            }while(!valorValidoD(pesoGramas2));



            int estoque2;
             do{
                estoque2 = InputUtils.lerInteiro("Insira a quantidade em estoque do produto: ");
                if(!valorValidoI(estoque2))
                 System.out.println("Insira um valor válido!(maior que zero)");

            }while(!valorValidoI(estoque2));
            break;
        }

        produtos[prod] = novo;
        prod++;

        System.out.println("Produto cadastrado com sucesso!");
    }

    private void alterarProduto() {
        System.out.println(">>> Alterar Produto <<<");
        String codigo = InputUtils.lerTexto("Insira o codigo do produto que queira alterar: ");
        for(int i=0; i<prod;i++){
            if(produtos[i].getCodigo().equalsIgnoreCase(codigo)){
                int atributo;
                if(produtos[i] instanceof ProdutoDigital){
                    atributo = escolheAtributo("1 - Código", "2 - Nome", "3 - Preço Base", "4 - Tamanho do Arquivo em MB", 
                                                "5 - Formato do Arquivo", "6 - Link para Download do Arquivo");
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
                        String novoFormatoDoArquivo = InputUtils.lerTexto("Insira o novo formato do arquivo: ");
                        ProdutoDigital pd1 = (ProdutoDigital) produtos[i];
                        pd1.setFormatoArquivo(novoFormatoDoArquivo);
                        break;
                    case 6:
                        String novoLinkDowload = InputUtils.lerTexto("Insira o novo link para dowload do arquivo: ");
                        ProdutoDigital pd2 = (ProdutoDigital) produtos[i];
                        pd2.setLinkDownload(novoLinkDowload);
                        break;
                    }
                }
                if(produtos[i] instanceof ProdutoFisico){
                    atributo = escolheAtributo("1 - Código", "2 - Nome", "3 - Preço Base", "4 - Peso em Gramas", 
                                                "5 - Estoque", "");
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
                    case 6:
                        break;
                    }
                }
                if(produtos[i] instanceof ProdutoPerecivel){
                    atributo = escolheAtributo("1 - Código", "2 - Nome", "3 - Preço Base", "4 - Peso em Gramas", 
                                                "5 - Estoque", "6 - Data de Validade");
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
                        ProdutoPerecivel pd = (ProdutoPerecivel) produtos[i];
                        pd.setPesoGramas(novopesoGramas);
                        break;
                    case 5:
                        int novoEstoque = InputUtils.lerInteiro("Insira a nova quantidade em estoque do produto: ");
                        ProdutoPerecivel pd1 = (ProdutoPerecivel) produtos[i];
                        pd1.setEstoque(novoEstoque);
                        break;
                    case 6:
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
        String identificador = InputUtils.lerTexto("Insira o identificador do cliente: ");
        while(clienteExiste(identificador)){
            System.out.println("Cliente já inserido, deseja cadastrar outro cliente?");
            int tentativa = InputUtils.lerInteiro("Digite 1 para SIM e 0 para NÃO: ");
            if(tentativa == 1)
                identificador = InputUtils.lerTexto("Insira o identificador do cliente: ");
            else{
                System.out.println("Cliente não cadastrado!");
                return;
            }
        }
        String nome = InputUtils.lerTexto("Insira o nome do cliente: ");
        String endereco = InputUtils.lerTexto("Insira o endereço do cliente: ");
        String telefone = InputUtils.lerTexto("Insira o telefone do cliente(exemplo->(DDD)NNNNN-NNNN ): ");
        
        int op;
        do {
            System.out.println("Insira o tipo do cliente: ");
            System.out.println("1 - Pessoa Física");
            System.out.println("2 - Pessoa Jurídica");
            op = InputUtils.lerInteiro("opção: ");
        }  while(op != 1 && op != 2);


        Cliente novo = null;
        switch (op){
        case 1:
            String cpf = InputUtils.lerTexto("Insira o CPF do cliente: ");
            LocalDate dataNascimento = InputUtils.lerData("Insira a data de nascimento do cliente: ");
            novo = new PessoaFisica(identificador, nome, endereco, telefone, cpf, dataNascimento);
            break;
        case 2:
            String cnpj = InputUtils.lerTexto("Insira o CNPJ do cliente ou empresa: ");
            String inscricaoEstadual = InputUtils.lerTexto("Insira a Inscrição Estadual do cliente ou empresa: ");
            novo = new PessoaJuridica(identificador, nome, endereco, telefone, cnpj, inscricaoEstadual);
            break;
        }

        clientes[clien] = novo;
        clien++;

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void alterarCliente() {
        System.out.println(">>> Alterar Cliente <<<");
        String identificador = InputUtils.lerTexto("Insira o identificador do cliente que queira alterar: ");
        for(int i=0; i<clien;i++){
            if(clientes[i].getIdentificador().equalsIgnoreCase(identificador)){
                int atributo;
                if(clientes[i] instanceof PessoaFisica){
                    atributo = escolheAtributo("1 - Identificador", "2 - Nome", "3 - Endereço", "4 - Telefone", 
                                                "5 - CPF", "6 - Data de Nascimento");
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
                    case 6:
                        LocalDate novaDataNascimento = InputUtils.lerData("Insira a nova data de nascimento do cliente: ");
                        PessoaFisica ps2 = (PessoaFisica) clientes[i];
                        ps2.setDataNascimento(novaDataNascimento);
                        break;
                    }
                }
                if(clientes[i] instanceof PessoaJuridica){
                    atributo = escolheAtributo("1 - Identificador", "2 - Nome", "3 - Endereço", "4 - Telefone", 
                                                "5 - CNPJ", "6 - Data de Nascimento");
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
                    case 6:
                        String novaInscricaoEstadual = InputUtils.lerTexto("Insira a nova Inscrição Estadual do cliente: ");
                        PessoaJuridica ps2 = (PessoaJuridica) clientes[i];
                        ps2.setInscricaoEstadual(novaInscricaoEstadual);
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
        for(int i = 0; i < clien; i++){
            System.out.println("<<< Clientes Cadastrados >>>");
            System.out.println(i+1 + "-  " + clientes[i].getNome());
        }
            int ncliente = InputUtils.lerInteiro("Selecione o cliente da nota: ");

        if(ncliente < 1 || ncliente > clien){
            System.out.println("Cliente inválido.");
            return;
        }

        clienteSelecionado = clientes[ncliente];
        

        novo = new Nota(clienteSelecionado);

        for(int i = 0; i < prod; i++){
            System.out.println("<<< Produtos Cadastrados >>>");
            System.out.println(i+1 + produtos[i].getNome());
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
            System.out.println("- Formato do Arquivo: " + pd.getFormatoArquivo());
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
            System.out.println("- Peso em Gramas do Produto: " + pd2.getPesoGramas());
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
            ps.exibirCliente();
            }

            if(clientes[i] instanceof PessoaJuridica){
            PessoaJuridica ps1 = (PessoaJuridica) clientes[i];
            System.out.println(i+1);
            ps1.exibirCliente();
            }
        }
    }
    
    public int escolheAtributo(String string1, String string2, String string3, String string4, String string5, String string6){
        int atributo;
        do {
                    System.out.println("Insira o qual atributo que deseja alterar: ");
                    System.out.println(string1);
                    System.out.println(string2);
                    System.out.println(string3);
                    System.out.println(string4);
                    System.out.println(string5);
                    System.out.println(string6);
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
private boolean nomeValido(String nome){
    return nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ\\s]+");
}
private boolean codigoValido(String codigo ){
    return codigo.matches("\\d{6}");//exatamente 6 digitos numericos
}
private boolean valorValido(BigDecimal valor){
    return valor != null && valor.compareTo(BigDecimal.ZERO) > 0;//valor é maior que 0.
}
 
private boolean valorValidoD(double valor){
    return valor > 0;
}
private boolean valorValidoI(int valor){
    return valor > 0;
}
private boolean verificarData(LocalDate data) {
    LocalDate inicio = LocalDate.of(2025, 7, 23);
    LocalDate fim = LocalDate.of(2026, 7, 23);

    return (data.isEqual(inicio) || data.isAfter(inicio)) &&
           (data.isEqual(fim) || data.isBefore(fim));
}
}

