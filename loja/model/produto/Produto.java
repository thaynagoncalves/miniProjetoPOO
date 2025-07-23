package loja.model.produto;

import java.math.BigDecimal;


public abstract class Produto{
    private String codigo;
    private String nome;
    private BigDecimal precoBase;

    
    public Produto(String codigo, String nome, BigDecimal precoBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public BigDecimal getPrecoBase() {
        return precoBase;
    }
    public void setPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
    }

}
