package loja.model.nota;

import java.util.Random;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import loja.model.cliente.Cliente;

public class Nota{
    Cliente cliente;
    ItemNota itens;
    long idNota;
    LocalDateTime dataEmissao;

    
    public Nota(Cliente cliente, ItemNota itens, BigDecimal subtotal, BigDecimal valorTotal) {
        this.cliente = cliente;
        this.itens = itens;
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

    public long getIdNota() {
        return idNota;
    }


    public void setIdNota(long idNota) {
        Random random = new Random();
         int min = 100000;
        int max = 999999;
        int numero = (int) (Math.random()* (max - min)) + min;
        this.idNota = numero; 
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        LocalDateTime now = LocalDateTime.now();
        this.dataEmissao = now;
    }

    

    
}