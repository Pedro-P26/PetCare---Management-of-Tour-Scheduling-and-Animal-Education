package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoRegisto extends JFrame {

    private JButton buttonback;
    private JPanel donoregisto;
    private JButton gerirEmpresaButton;
    private JButton gerirFuncionáriosButton;

    public DonoRegisto(JFrame frame){
        frame.add(donoregisto);
        frame.pack();
        frame.setVisible(true);
        gerirempresa(frame);
        gerirfuncionarios(frame);
        returnback(frame);
        frame.setSize(400, 300);
    }


    public void gerirempresa(JFrame frame){
        gerirEmpresaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoregisto.setVisible(false);
                new DonoGereEmpresa(frame);
            }
        });
    }

    public void gerirfuncionarios(JFrame frame){
        gerirFuncionáriosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoregisto.setVisible(false);
                new DonoGereFuncionarios(frame);
            }
        });
    }

    public void returnback(JFrame frame){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoregisto.setVisible(false);
                new Login(frame);
            }
        });
    }



}
