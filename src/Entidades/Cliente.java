package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enumerados.StatusServico;
import Repositorios.*;

public class Cliente extends User  {

    private static final long serialVersionUID = 1902487263223L;
    //private List<Servico> marcacoes;

    public Cliente(String username, String password, String nome, int numeroCC, int numeroIF, int telefone, String morada, String localidade) {
        super(username, password, nome, numeroCC, numeroIF, telefone, morada, localidade);
        //this.marcacoes = new ArrayList<>();
    }
/*
    public List<Servico> getMarcacoes() {

        return marcacoes;
    }

    public void setMarcacoes(List<Servico> marcacoes) {
        this.marcacoes = marcacoes;
    }

    public void adicionarServico(Servico servico) {
        if (servico != null && isValidServico(servico)) {
            marcacoes.add(servico);
            System.out.println("Serviço adicionado com sucesso para a data " + servico.getDataservico());
        } else {
            System.out.println("Erro ao adicionar serviço");
        }
    }

    private boolean isValidServico(Servico servico) {

        return servico.getDataservico() != null && servico.getDataservico().after(new Date());
    }

    public List<Servico> consultarMarcacoesConfirmadas(StatusServico status) {
        List<Servico> marcacoesFiltradas = new ArrayList<>();

        for (Servico servico : marcacoes) {
            if (servico.getStatusservico() == StatusServico.MARCADA) {
                marcacoesFiltradas.add(servico);
            }
        }
        return marcacoesFiltradas;
    }

    public List<Servico> ConsultarServicoConcluido(StatusServico status) {
        List<Servico> marcacoesFiltradas = new ArrayList<>();

        for (Servico servico : marcacoes) {
            if (servico.getStatusservico() == StatusServico.CONCLUIDA) {
                marcacoesFiltradas.add(servico);
            }
        }
        return marcacoesFiltradas;
    }

    public List<Servico> ConsultarServicoCancelado(StatusServico status) {
        List<Servico> marcacoesFiltradas = new ArrayList<>();

        for (Servico servico : marcacoes) {
            if (servico.getStatusservico() == StatusServico.ANULADA) {
                marcacoesFiltradas.add(servico);
            }
        }
        return marcacoesFiltradas;
    }



    public void efetuarPagamento(Servico servico) {
        if (servico != null && servico.getStatusservico() == StatusServico.CONFIRMADA) {

            //incompleto aqui

            servico.setStatusservico(StatusServico.CONCLUIDA);
            servico.setDatapagamento(new Date());

            System.out.println("Pagamento efetuado com sucesso para o serviço agendado em " + servico.getDataservico());
        } else {
            System.out.println("Erro ao efetuar o pagamento. Serviço não confirmado ou inválido.");
        }
    }
*/
}
