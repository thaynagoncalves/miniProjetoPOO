package loja.model.nota;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import loja.model.cliente;

public class Nota{
    Cliente cliente;
    ItemNota itens;
    String idNota;
    LocalDateTime dataEmissao;

    
    public Nota(Cliente cliente, ItemNota itens, String idNota, LocalDateTime dataEmissao, BigDecimal subtotal,
            BigDecimal valorTotal) {
        this.cliente = cliente;
        this.itens = itens;
        this.idNota = idNota;
        this.dataEmissao = dataEmissao;

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemNota getItens() {
        return itens;
    }

    public void setItens(ItemNota itens) {
        this.itens = itens;
    }

    public String getIdNota() {
        return idNota;
    }

    public void setIdNota(String idNota) {
        this.idNota = idNota;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    

    
}