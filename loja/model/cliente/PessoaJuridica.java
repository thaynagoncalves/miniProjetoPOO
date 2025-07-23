package loja.model.cliente;

public class PessoaJuridica extends Cliente{
    private String cnpj;
    
    public PessoaJuridica(String identificador, String nome, String endereco, String telefone, String cnpj) {
        super(identificador, nome, endereco, telefone);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    @Override
    public void exibirCliente(){
        super.exibirCliente();
        System.out.println("- Tipo: Pessoa Jurídica");
        System.out.println("- CNPJ: " + this.cnpj);
    }
    
}