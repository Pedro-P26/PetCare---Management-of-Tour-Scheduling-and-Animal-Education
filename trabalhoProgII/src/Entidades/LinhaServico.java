package Entidades;

import java.io.Serializable;

public class LinhaServico implements Serializable {

    private int qtd;
    private ProdutoServico produto;
    private float precototal;

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public ProdutoServico getProduto() {
        return produto;
    }

    public void setProduto(ProdutoServico produto) {
        this.produto = produto;
    }

    public float getPrecototal() {
        return precototal;
    }

    public void setPrecototal(float precototal) {
        this.precototal = precototal;
    }
}
