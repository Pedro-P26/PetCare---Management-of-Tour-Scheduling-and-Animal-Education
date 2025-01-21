package Entidades;

import java.io.Serializable;

public class LocalEntrega implements Serializable {

    private String morada;
    private String localidade;
    private int telefone;
    //private String codPostal;
    private String nomeprestador;
    private tiposervico tipo;

    public enum tiposervico{

        educacao_de_cao,
        passio_de_cao,
        educacao_de_gato,
        tosquia
    }
    //public LocalEntrega() {
    //}

    public LocalEntrega(String morada, String localidade, int telefone, String nomeprestador, tiposervico tipo) {
        this.morada = morada;
        this.localidade = localidade;
        this.telefone = telefone;
        //this.codPostal = codPostal;
        this.nomeprestador = nomeprestador;
        this.tipo = tipo;
    }

    public tiposervico getTipo() {
        return tipo;
    }

    public void setTipo(tiposervico tipo) {
        this.tipo = tipo;
    }

    public String getNomeprestador() {
        return nomeprestador;
    }

    public void setNomeprestador(String nomeprestador) {
        this.nomeprestador = nomeprestador;
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


}
