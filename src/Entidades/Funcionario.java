package Entidades;
import java.sql.Time;
import java.util.Date;

public class Funcionario extends User{
    private static final long serialVersionUID = 121894372422489L;

    private String profissao;
    private float salario;
    private Time horatioini;
    private Time horariofim;
    private String nomeprestador;
    private Tipopro tipoprofissao;

    public enum Tipopro{
        veterinario,
        educador_animal,
        auxiliar,
        secretario
    }

    public Funcionario(String username, String password,String nome, int numeroCC, int numeroIF, int telefone, String morada, String localidade,Tipopro tipoprofissao,float salario, Time horarioini, Time horariofim,String nomeprestador) {
        super(username, password, nome, numeroCC, numeroIF, telefone, morada, localidade);
        //this.profissao = profissao;
        this.salario = salario;
        this.horatioini = horarioini;
        this.horariofim = horariofim;
        this.nomeprestador = nomeprestador;
        this.tipoprofissao = tipoprofissao;
    }

    public Tipopro getTipoprofissao() {
        return tipoprofissao;
    }

    public void setTipoprofissao(Tipopro tipoprofissao) {
        this.tipoprofissao = tipoprofissao;
    }

    public String getNomeprestador() {
        return nomeprestador;
    }

    public void setNomeprestador(String nomeprestador) {
        this.nomeprestador = nomeprestador;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Date getHoratioini() {
        return horatioini;
    }

    public void setHoratioini(Time horatioini) {
        this.horatioini = horatioini;
    }

    public Date getHorariofim() {
        return horariofim;
    }

    public void setHorariofim(Time horariofim) {
        this.horariofim = horariofim;
    }
}
