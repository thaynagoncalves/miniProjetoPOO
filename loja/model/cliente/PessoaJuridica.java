package loja.model.cliente;

public class PessoaJuridica extends Cliente{
    private String cnpj;
    private String inscricaoEstadual;
    
    public PessoaJuridica(String identificador, String nome, String endereco, String telefone, String cnpj,
            String inscricaoEstadual) {
        super(identificador, nome, endereco, telefone);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
    
}