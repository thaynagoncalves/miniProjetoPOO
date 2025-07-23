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
    private int numItens = 0;
    long idNota;
    LocalDateTime dataEmissao;

    
    public Nota(Cliente cliente) {
        this.cliente = cliente;
        this.dataEmissao = LocalDateTime.now();
        setIdNota();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdNota() {
        int min = 100000;
        int max = 999999;
        int numero = (int) (Math.random()* (max - min)) + min;
        this.idNota = numero; 
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
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

        System.out.println("\n\n\n");

        System.out.println("CÓDIGO     DESCRIÇÃO           QTDE   VALOR UNITÁRIO   TOTAL");
        for (int i = 0; i < numItens; i++) {
        Produto produto = itens[i].getProduto();
        String codigo = espacarDireita(produto.getCodigo(), 10);
        String nome = espacarDireita(produto.getNome(), 18);
        String qtde = espacarEsquerda(String.valueOf(itens[i].getQuantidade()), 5);
        String preco = espacarEsquerda(String.format("%.2f", produto.getPrecoBase()), 16);
        String total = espacarEsquerda(String.format("%.2f", itens[i].getTotalItem()), 10);

        System.out.println(codigo + nome + " " + qtde + "   " + preco + "   " + total);
        }

        System.out.println("\nQUANTIDADE TOTAL DE ITENS: " + itensTotal());
        System.out.println("VALOR TOTAL DA NOTA: R$ " + String.format("%.2f", valorTotal()));
    }


    private boolean produtoNaNotaExiste(Produto produto) {
    for (int i = 0; i < numItens; i++) {
        if (itens[i].getProduto().getCodigo().equalsIgnoreCase(produto.getCodigo())) 
            return true;
        }
    return false;
    }

    private String espacarDireita(String texto, int tamanho) {
    return String.format("%-" + tamanho + "s", texto);
    }


    private String espacarEsquerda(String texto, int tamanho) {
        return String.format("%" + tamanho + "s", texto);
    }
}