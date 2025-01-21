package Entidades;

import java.io.Serializable;

public class PrestadorServico implements Serializable {

    private String nome;
    private String morada;
    private String localidade;
    private int telefone;
    //private TipoServico tipo;
    private String Dono;
    private TipoServico tipo;

    private static final long serialVersionUID = -3408483548031875420L;
    public PrestadorServico(String nome, String morada, String localidade, int telefone, String Dono){
        this.nome = nome;
        this.morada = morada;
        this.localidade = localidade;
        this.telefone = telefone;
        this.Dono = Dono;
        //this.tipo=tipo;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public void setTipo(TipoServico tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

   /* public TipoServico getTipo() {
        return tipo;
    }

    public void setTipo(TipoServico tipo) {
        this.tipo = tipo;
    }*/

    public String getDono() {
        return Dono;
    }

    public void setDono(String dono) {
        Dono = dono;
    }
}
