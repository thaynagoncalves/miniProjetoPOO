package loja.model.nota;

import java.math.BigDecimal;
import loja.model.produto.Produto;

public class ItemNota {
    private Produto produto;
    private int quantidade;
    private BigDecimal precoUnitario;

    
    public ItemNota(Produto produto, int quantidade, BigDecimal precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }


    public Produto getProduto() {
        return produto;
    }


    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }


    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getTotalItem() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
    
}