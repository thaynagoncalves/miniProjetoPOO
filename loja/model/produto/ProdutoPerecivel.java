package loja.model.produto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ProdutoPerecivel extends Produto{
    private LocalDate dataValidade;
    private double pesoGramas;
    private int estoque;

    
    public ProdutoPerecivel(String codigo, String nome, BigDecimal precoBase, double pesoGramas, LocalDate dataValidade, int estoque) {
        super(codigo, nome, precoBase);
        this.dataValidade = dataValidade;
        this.pesoGramas = pesoGramas;
        this.estoque = estoque;
    }

    public double getPesoGramas() {
        return pesoGramas;
    }

    public void setPesoGramas(double pesoGramas) {
        this.pesoGramas = pesoGramas;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public boolean estaVencido() {
        return dataValidade.isBefore(LocalDate.now());
    }
    
}
