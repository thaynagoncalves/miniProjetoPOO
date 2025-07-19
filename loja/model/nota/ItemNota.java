package loja.model.nota;

import java.math.BigDecimal;
import loja.model.produto.Produto;

public class ItemNota {
    private Produto produto;
    private int quantidade;

    
    public ItemNota(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
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


    public BigDecimal getTotalItem() {
        return produto.getPrecoBase().multiply(BigDecimal.valueOf(quantidade));
    }
    
}