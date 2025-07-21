package loja.model.nota;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import loja.model.cliente.Cliente;

public class Nota{
    Cliente cliente;
    ItemNota[] itens = new ItemNota[200];;
    long idNota;
    LocalDateTime dataEmissao;

    
    public Nota(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public long getIdNota() {
        return idNota;
    }


    public void setIdNota(long idNota) {
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