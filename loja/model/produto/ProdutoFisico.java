package loja.model.produto;

import java.math.BigDecimal;

public class ProdutoFisico extends Produto{
    private int pesoGramas;
    private int estoque;
    
    public ProdutoFisico(String codigo, String nome, BigDecimal precoBase, int pesoGramas, int estoque) {
        super(codigo, nome, precoBase);
        this.pesoGramas = pesoGramas;
        this.estoque = estoque;
    }

    public int getPesoGramas() {
        return pesoGramas;
    }

    public void setPesoGramas(int pesoGramas) {
        this.pesoGramas = pesoGramas;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}