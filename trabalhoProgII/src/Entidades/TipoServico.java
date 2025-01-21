package Entidades;

import Enumerados.TipoServicos;

import java.io.Serializable;

public class TipoServico implements Serializable {


    private float preco;
    private TipoServicos tipo;

    public TipoServico(){}

    public TipoServico( float preco,TipoServicos tipo) {

        this.preco = preco;
        this.tipo = tipo;
    }

    public TipoServicos getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicos tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
