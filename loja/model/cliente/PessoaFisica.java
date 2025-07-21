package loja.model.cliente;

import java.time.LocalDate;

public class PessoaFisica extends Cliente{
    private String cpf;
    private LocalDate dataNascimento;
    
    public PessoaFisica(String identificador, String nome, String endereco, String telefone, String cpf,
            LocalDate dataNascimento) {
        super(identificador, nome, endereco, telefone);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public void exibirCliente(){
        super.exibirCliente();
        System.out.println("- Tipo: Pessoa Física");
        System.out.println("- CPF: " + this.cpf);
        System.out.println("- Data de Nascimento: " + this.dataNascimento);
    }
}