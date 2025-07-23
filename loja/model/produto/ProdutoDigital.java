package loja.model.produto;

import java.math.BigDecimal;

public class ProdutoDigital extends Produto {
    private double tamanhoArquivoEmMB;
    private String linkDownload;

    public ProdutoDigital(String codigo, String nome, BigDecimal precoBase, double tamanhoArquivoEmMB, String linkDownload) {
        super(codigo, nome, precoBase);
        this.tamanhoArquivoEmMB = tamanhoArquivoEmMB;
        this.linkDownload = linkDownload;
    }

    public double getTamanhoArquivoEmMB() {
        return tamanhoArquivoEmMB;
    }

    public void setTamanhoArquivoEmMB(double tamanhoArquivoEmMB) {
        this.tamanhoArquivoEmMB = tamanhoArquivoEmMB;
    }


    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }

}
