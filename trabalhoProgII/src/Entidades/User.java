package Entidades;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 121894372422489L;

    private String username;
    private String password;
    private String nome;
    private int numeroCC;
    private int numeroIF;
    private int telefone;
    private String morada;
    private String localidade;

    public User(){}

    public User(String username, String password,String nome, int numeroCC, int numeroIF, int telefone, String morada, String localidade) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.numeroCC = numeroCC;
        this.numeroIF = numeroIF;
        this.telefone = telefone;
        this.morada = morada;
        this.localidade = localidade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroCC() {
        return numeroCC;
    }

    public void setNumeroCC(int numeroCC) {
        this.numeroCC = numeroCC;
    }

    public int getNumeroIF() {
        return numeroIF;
    }

    public void setNumeroIF(int numeroIF) {
        this.numeroIF = numeroIF;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
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

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nNúmero de Cartão de Cidadão: " + numeroCC +
                "\nNúmero Fiscal: " + numeroIF +
                "\nTelefone: " + telefone +
                "\nMorada: " + morada +
                "\nLocalidade: " + localidade;
    }
}
