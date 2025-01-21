package Entidades;

import java.io.Serializable;

public class ProdutoServico implements Serializable {

    private String descricao;
    private float preco;
    private String nomeprestador;

    public ProdutoServico(){}

    public ProdutoServico(String descricao, float preco, String nomeprestador) {
        this.descricao = descricao;
        this.preco = preco;
        this.nomeprestador = nomeprestador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNomeprestador() {
        return nomeprestador;
    }

    public void setNomeprestador(String nomeprestador) {
        this.nomeprestador = nomeprestador;
    }
}
