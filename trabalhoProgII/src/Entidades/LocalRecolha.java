package Entidades;

import java.io.Serializable;

public class LocalRecolha implements Serializable {

    //private String nome;
    private String morada;
    private String localidade;
    private int telefone;
    //private String codPostal;
    private String nomeprestador;
    private Tipo tipos;
    public enum Tipo{

        educacao_de_cao,
        passio_de_cao,
        educacao_de_gato,
        tosquia
    }

    //public LocalRecolha() {
    //}

    public LocalRecolha(String morada,String localidade, int telefone, String nomeprestador,Tipo tipos) {
        //this.nome = nome;
        this.morada = morada;
        this.localidade = localidade;
        this.telefone = telefone;
        //this.codPostal = codPostal;
        this.nomeprestador = nomeprestador;
        this.tipos = tipos;
    }

    public Tipo getTipos() {
        return tipos;
    }

    public void setTipos(Tipo tipos) {
        this.tipos = tipos;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }



    public String getNomeprestador() {
        return nomeprestador;
    }

    public void setNomeprestador(String nomeprestador) {
        this.nomeprestador = nomeprestador;
    }

    /*public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }*/

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

   /* public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }*/
}
