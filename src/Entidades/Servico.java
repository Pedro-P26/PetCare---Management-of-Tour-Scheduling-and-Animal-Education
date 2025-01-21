package Entidades;

import Enumerados.StatusServico;
import Enumerados.TipoServicos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Servico implements Serializable {
    private static final long serialVersionUID = -1684463704274644876L;
    private Date dataservico;
    private float precototal;
    private Date datapagamento;
    private float precoservico;
    private StatusServico statusservico;
    private String usercliente;
    private TipoServico tiposervico;
    private int nchip;
    private String nomeprestador;
    //private List<LinhaServico> linhas;
    //private Servicos servicos;
    private Tratamento tratar;

    public enum Tratamento{
        educar_cao,
        passeio_cao,
        educacao_cao,
        tosquia
    }



    public Servico(int nchip,String nomeprestador,Date dataservico, StatusServico statusservico, String usercliente) {
        this.dataservico = dataservico;
        this.statusservico = statusservico;
        this.usercliente = usercliente;
        //this.tiposervico = tiposervico;
        //this.precoservico = precoservico;
        this.nchip = nchip;
        this.nomeprestador = nomeprestador;
        ///linhas = new ArrayList<>();
        //this.tratar=tratar;
    }

    public Tratamento getTratar() {
        return tratar;
    }

    public void setTratar(Tratamento tratar) {
        this.tratar = tratar;
    }

    public float getPrecototal() {
        return precototal;
    }

    public String getNomeprestador() {
        return nomeprestador;
    }

    public void setNomeprestador(String nomeprestador) {
        this.nomeprestador = nomeprestador;
    }

    public String getDescricaoServico(){
        return "Data Servico: "+dataservico+"\n"+ "Preco Total: "+precototal+"\n"+"Data Pagamento: "+datapagamento+"\n"+"Preco Servico: "+precoservico+"\n"+"Status Servico: "+statusservico+"\n"+"Tipo Servico: "+tiposervico+"\n"+"Chip Animal: "+nchip+"\n";
    }

    public Date getDataservico() {
        return dataservico;
    }

    public void setDataservico(Date dataservico) {
        this.dataservico = dataservico;
    }

    public void setPrecototal(float precototal) {
        this.precototal = precototal;
    }

    public Date getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(Date datapagamento) {
        this.datapagamento = datapagamento;
    }

    public float getPrecoservico() {
        return precoservico;
    }

    public void setPrecoservico(float precoservico) {
        this.precoservico = precoservico;
    }

    public StatusServico getStatusservico() {
        return statusservico;
    }

    public void setStatusservico(StatusServico statusservico) {
        this.statusservico = statusservico;
    }

    public String getUsercliente() {
        return usercliente;
    }

    public void setUsercliente(String usercliente) {
        this.usercliente = usercliente;
    }

    public TipoServico getTiposervico() {
        return tiposervico;
    }

    public void setTiposervico(TipoServico tiposervico) {
        this.tiposervico = tiposervico;
    }

    public int getNchip() {
        return nchip;
    }

    public void setNchip(int nchip) {
        this.nchip = nchip;
    }


    public void getStatusservico(StatusServico stat) {
    }
}
