package loja.model.produto;

import java.math.BigDecimal;

public class ProdutoFisico extends Produto{
    private double pesoGramas;
    private int estoque;
    private BigDecimal frete;
    
    public ProdutoFisico(String codigo, String nome, BigDecimal precoBase, double pesoGramas, int estoque,
            BigDecimal frete) {
        super(codigo, nome, precoBase);
        this.pesoGramas = pesoGramas;
        this.estoque = estoque;
        this.frete = frete;
    }

    public double getPesoGramas() {
        return pesoGramas;
    }

    public void setPesoGramas(double pesoGramas) {
        this.pesoGramas = pesoGramas;
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

    
}