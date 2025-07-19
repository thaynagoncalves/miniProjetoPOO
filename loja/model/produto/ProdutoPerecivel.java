package loja.model.produto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ProdutoPerecivel extends Produto{
    private LocalDate dataValidade;
    private int estoque;
    private BigDecimal frete;
    
    public ProdutoPerecivel(String codigo, String nome, BigDecimal precoBase, LocalDate dataValidade, int estoque,
            BigDecimal frete) {
        super(codigo, nome, precoBase);
        this.dataValidade = dataValidade;
        this.estoque = estoque;
        this.frete = frete;
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

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }
    
    
    public boolean estaVencido() {
        return dataValidade.isBefore(LocalDate.now());
    }
    
}