package loja.model.produto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ProdutoPerecivel extends ProdutoFisico{
    private LocalDate dataValidade;

    
    public ProdutoPerecivel(String codigo, String nome, BigDecimal precoBase, double pesoGramas, LocalDate dataValidade, int estoque) {
        super(codigo, nome, precoBase, pesoGramas, estoque);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    public boolean estaVencido() {
        return dataValidade.isBefore(LocalDate.now());
    }
    
}