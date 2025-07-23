package loja.model.cliente;


public class PessoaFisica extends Cliente {
    private String cpf;
    
    public PessoaFisica(String identificador, String nome, String endereco, String telefone, String cpf) {
        super(identificador, nome, endereco, telefone);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    @Override
    public void exibirInformacoes(){
        super.exibirInformacoes();
        System.out.println("- Tipo: Pessoa Física");
        System.out.println("- CPF: " + this.cpf);
    }
}