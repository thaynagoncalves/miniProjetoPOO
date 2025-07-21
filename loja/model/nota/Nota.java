package loja.model.nota;


import java.time.LocalDateTime;
import loja.model.cliente.Cliente;

public class Nota{
    Cliente cliente;
    ItemNota[] itens = new ItemNota[200];
    private static int numItens = 0;
    long idNota;
    LocalDateTime dataEmissao;

    
    public Nota(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
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

    
    public void imprimirNota(){
        System.out.println("Nota N° " + this.idNota);
        System.out.println("Emissão: " + this.dataEmissao);
        this.cliente.exibirCliente();
        System.out.println("CÓDIGO     DESCRIÇÃO            QTDE.   VALOR UNITÁRIO   TOTAL");
        for(int i=0; i<numItens; i++){
            System.out.println(this.itens[i].getProduto().getCodigo()+"    "+this.itens[i].getProduto().getNome()+
                                "    "+this.itens[i].getProduto()+"    "+this.itens[i].getQuantidade()+"    "+
                                this.itens[i].getProduto().getPrecoBase()+"    "+this.itens[i].getTotalItem()+"    ");
        }
    }
    
}