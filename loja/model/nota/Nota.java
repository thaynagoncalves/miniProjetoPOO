package loja.model.nota;



import java.math.BigDecimal;
import java.time.LocalDateTime;

import loja.model.produto.Produto;


import loja.model.cliente.Cliente;
import loja.model.cliente.PessoaFisica;
import loja.model.cliente.PessoaJuridica;

import loja.ui.InputUtils;

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

    public void cadastrarItemNota(Produto produto, int quantidade) {
        while(produtoNaNotaExiste(produto)){
            System.out.println("Produto já inserido!");
            return;
            }

        ItemNota novo = new ItemNota(produto, quantidade);

        itens[numItens] = novo;
        numItens++;

        System.out.println("Produto cadastrado na Nota com sucesso!");
        InputUtils.pausar();
    }

    public BigDecimal valorTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for(int i=0; i<numItens; i++){
            total = total.add(this.itens[i].getTotalItem());
        }
        return total;
    }

        public int itensTotal(){
        int total = 0;
        for(int i=0; i<numItens; i++){
            total += this.itens[i].getQuantidade();
        }
        return total;
    }

    public void imprimirNota(){
        System.out.println("Nota N° " + this.idNota);
        System.out.println("Emissão: " + this.dataEmissao);
        if(cliente instanceof PessoaFisica){
            PessoaFisica ps = (PessoaFisica) this.cliente;
            ps.exibirInformacoes();
        }
        if(cliente instanceof PessoaJuridica){
            PessoaJuridica ps = (PessoaJuridica) this.cliente;
            ps.exibirInformacoes();
        }
        System.out.println("CÓDIGO     DESCRIÇÃO            QTDE.   VALOR UNITÁRIO   TOTAL");
        for(int i=0; i<numItens; i++){
            System.out.println(this.itens[i].getProduto().getCodigo()+"    "+this.itens[i].getProduto().getNome()+
                                "    "+"    "+this.itens[i].getQuantidade()+"    "+
                                this.itens[i].getProduto().getPrecoBase()+"    "+this.itens[i].getTotalItem()+"    ");
        }
        System.out.println("QUANTIDADE TOTAL DE                      " + itensTotal());
        System.out.println("VALOR TOTAL R$                           " + valorTotal());
    }
    private boolean produtoNaNotaExiste(Produto produto) {
    for (int i = 0; i < numItens; i++) {
        if (itens[i].getProduto().getCodigo().equalsIgnoreCase(produto.getCodigo())) 
            return true;
        }
    return false;
    }
}