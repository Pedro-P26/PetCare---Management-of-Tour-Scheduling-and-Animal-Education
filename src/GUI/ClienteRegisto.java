package GUI;

import Repositorios.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteRegisto extends JFrame {

    private JPanel clienteregisto;
    private JButton registarAnimalButton;
    private JButton registarServicoButton;
    private JButton pagarServicoButton;
    private JButton returnButton;
    private JButton listarAnimaisButton;
    private JButton listarPrestadoresServicosButton;
    private JButton listarServicosButton;


    public ClienteRegisto(JFrame frame){
        frame.add(clienteregisto);
        frame.pack();
        frame.setVisible(true);
        returnButton(frame);
        adicionarAnimal(frame);
        listaranimais(frame);
        listarprestadores(frame);
        registarservico(frame);
        pagarservico(frame);
        listarservicos(frame);
        frame.setSize(400, 300);
    }

    public void returnButton(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteregisto.setVisible(false);
                new Login(frame);
            }
        });
    }

    public void adicionarAnimal(JFrame frame){
        registarAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteregisto.setVisible(false);
                new RegistarAnimal(frame,Repositorio.getInstance().getIniUser());
            }
        });
    }
    public void listaranimais(JFrame frame){
        listarAnimaisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteregisto.setVisible(false);
                new ClienteListarAnimais(frame);
            }
        });
    }

    public void listarprestadores(JFrame frame){
        listarPrestadoresServicosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteregisto.setVisible(false);
                new ClienteListaPrestadores(frame);
            }
        });
    }

    public void registarservico(JFrame frame){
        registarServicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteregisto.setVisible(false);
                new ClienteMarcaServico(frame);
            }
        });
    }

    public void pagarservico(JFrame frame){
        pagarServicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteregisto.setVisible(false);
                new ClientePagaServico(frame);
            }
        });
    }

    public void listarservicos(JFrame frame){
        listarServicosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteregisto.setVisible(false);
                new ClienteListaServicos(frame);
            }
        });
    }
}
