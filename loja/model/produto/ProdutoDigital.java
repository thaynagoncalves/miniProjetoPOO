package loja.model.produto;

import java.math.BigDecimal;

public class ProdutoDigital extends Produto{
    private int tamanhoArquivoEmMB;
    private String formatoArquivo;
    private String linkDownload;

    public ProdutoDigital(String codigo, String nome, BigDecimal precoBase, int tamanhoArquivoEmMB,
            String formatoArquivo, String linkDownload) {
        super(codigo, nome, precoBase);
        this.tamanhoArquivoEmMB = tamanhoArquivoEmMB;
        this.formatoArquivo = formatoArquivo;
        this.linkDownload = linkDownload;
    }

    public int getTamanhoArquivoEmMB() {
        return tamanhoArquivoEmMB;
    }

    public void setTamanhoArquivoEmMB(int tamanhoArquivoEmMB) {
        this.tamanhoArquivoEmMB = tamanhoArquivoEmMB;
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }

}