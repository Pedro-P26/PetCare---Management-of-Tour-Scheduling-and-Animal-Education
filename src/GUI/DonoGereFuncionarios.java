package GUI;

import Repositorios.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoGereFuncionarios extends JFrame{
    private JPanel donogerefuncionarios;
    private JButton buttonback;
    private JButton removerFuncionarioButton;
    private JButton listarFuncionariosButton;
    private JButton adicionarFuncionarioButton;

    public DonoGereFuncionarios(JFrame frame){
        frame.add(donogerefuncionarios);
        frame.pack();
        frame.setVisible(true);
        removerfuncionario(frame);
        listafuncionarios(frame);
        backbutton(frame);
        adicionarfuncionario(frame);

        frame.setSize(400, 300);

    }

    public void adicionarfuncionario(JFrame frame){
        adicionarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogerefuncionarios.setVisible(false);
                new RegistarFuncionario(frame, Repositorio.getInstance().getIniUser());
            }
        });
    }
    public void removerfuncionario(JFrame frame){
        removerFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogerefuncionarios.setVisible(false);
                new SelectPrestadorRemoveFun(frame);
            }
        });
    }

    public void listafuncionarios(JFrame frame){
        listarFuncionariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogerefuncionarios.setVisible(false);
                new DonoListaFuncionario(frame);
            }
        });
    }


    public void backbutton(JFrame frame){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donogerefuncionarios.setVisible(false);
                new DonoRegisto(frame);
            }
        });
    }

}
