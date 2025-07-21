package loja.model.cliente;

public class Cliente{
    private String identificador;
    private String nome;
    private String endereco;
    private String telefone;
    
    public Cliente(String identificador, String nome, String endereco, String telefone) {
        this.identificador = identificador;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador){
        this.identificador = identificador;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
}
