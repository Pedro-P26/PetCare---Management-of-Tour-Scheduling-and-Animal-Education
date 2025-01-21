package GUI;

import Repositorios.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoGereEmpresa extends JFrame{
    private JPanel donogereempresa;
    private JButton RegistarEmpresa;
    private JButton buttonback;
    private JButton addlocalentrega;
    private JButton registarLocalRecolhaButton;
    private JButton alterarInfoPrestadorButton;
    private JButton alterarInfoLocalEntregaButton;
    private JButton alterarInfoLocalRecolhaButton;
    private JButton listarLocaisEntregasButton;
    private JButton listarLocaisRecolhasButton;
    private JButton ALterarinfoServicoButton;

    public DonoGereEmpresa(JFrame frame){
        frame.add(donogereempresa);
        frame.pack();
        frame.setVisible(true);
        RegistarEmpresa(frame);
        buttonback(frame);
        alterarinfo(frame);
        adicionarlocalentrega(frame);
        adicionarlocalrecolha(frame);
        listarrecolha(frame);
        listarentrega(frame);
        alterarinfolocalentrega(frame);
        alterarinfolocalrecolha(frame);
        alterarservico(frame);
        frame.setSize(400, 500);

    }
    public void alterarservico(JFrame frame){
        ALterarinfoServicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogereempresa.setVisible(false);
                new DonoAlteraServico(frame,Repositorio.getInstance().getIniUser());
            }
        });
    }

    public void RegistarEmpresa(JFrame frame){
        RegistarEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogereempresa.setVisible(false);
                new DonoRegistarEmpresa(frame);
            }
        });
    }
    public void buttonback(JFrame frame){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogereempresa.setVisible(false);
                new DonoRegisto(frame);
            }
        });

    }

    public void alterarinfo(JFrame frame){
        alterarInfoPrestadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogereempresa.setVisible(false);
                new DonoAlteraInfoPrestador1(frame);
            }
        });
    }

    public void adicionarlocalentrega(JFrame frame){
        addlocalentrega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogereempresa.setVisible(false);
                new DonoRegistaLocalEntrega(frame,Repositorio.getInstance().getIniUser());
            }
        });
    }

    public void adicionarlocalrecolha(JFrame frame){
        registarLocalRecolhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogereempresa.setVisible(false);
                new DonoRegistaLocalRecolha(frame,Repositorio.getInstance().getIniUser());
            }
        });
    }

    public void listarrecolha(JFrame frame){
        listarLocaisRecolhasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogereempresa.setVisible(false);
                new EscolherPrestadorListaRecolha(frame);
            }
        });
    }

    public void listarentrega(JFrame frame){
        listarLocaisEntregasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogereempresa.setVisible(false);
                new EscolherPrestadorListaEntrega(frame);
            }
        });
    }

    public void alterarinfolocalentrega(JFrame frame){
        alterarInfoLocalEntregaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogereempresa.setVisible(false);
                new EscolherPrestadorAltInfoLocalEntrega(frame);
            }
        });
    }

    public void alterarinfolocalrecolha(JFrame frame){
        alterarInfoLocalRecolhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogereempresa.setVisible(false);
                new EscolherPrestadorAltInfoLocalRecolha(frame);
            }
        });
    }
}
