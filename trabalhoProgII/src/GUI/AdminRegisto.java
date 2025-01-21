package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRegisto extends JFrame {

    private JPanel adminregisto;
    private JButton criarNovoAdminButton;
    private JButton desativarPrestadorDeServiçoButton;
    private JButton returnButton;
    private JButton listarPrestadoresDisponíveisButton;
    private JButton listarServiçosConfirmadosButton;


    public AdminRegisto(JFrame frame){
        frame.add(adminregisto);
        frame.pack();
        frame.setVisible(true);
        returnButton(frame);
        novoadminButton(frame);
        listarprestadores(frame);
        removerprestador(frame);
        listarservicosconfirmados(frame);
        frame.setSize(400, 300);
    }

    public void returnButton(JFrame frame){

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminregisto.setVisible(false);
                new Login(frame);
            }
        });
    }

    public void novoadminButton(JFrame frame){
        criarNovoAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminregisto.setVisible(false);
                new RegistoAdmin(frame);
            }
        });
    }

    public void listarprestadores(JFrame frame){
        listarPrestadoresDisponíveisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminregisto.setVisible(false);
                new AdminListaPrestadores(frame);
            }
        });
    }

    public void removerprestador(JFrame frame){
        desativarPrestadorDeServiçoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminregisto.setVisible(false);
                new AdminRemovePrestador(frame);
            }
        });
    }

    public void listarservicosconfirmados(JFrame frame){
        listarServiçosConfirmadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminregisto.setVisible(false);
                new AdminListaServicos(frame);
            }
        });
    }

}
