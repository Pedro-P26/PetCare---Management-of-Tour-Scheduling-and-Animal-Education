package Entidades;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Animal implements Serializable {

    private String nome;
    private String especie;
    private String raca;
    private int nchip;
    private Date datanasc;
    private String Dono;

    //public Animal(String nome, String especie, String raca, int nchip, Date datanasc, String username){}

    public Animal(String nome, String especie, String raca, int nchip, Date datanasc,String Dono){
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.nchip = nchip;
        this.datanasc = datanasc;
        this.Dono = Dono;
    }

    public String getDono() {
        return Dono;
    }

    public void setDono(String dono) {
        Dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getNchip() {
        return nchip;
    }

    public void setNchip(int nchip) {
        this.nchip = nchip;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }
}
